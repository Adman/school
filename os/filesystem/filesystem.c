#include "filesystem.h"
#include "util.h"

#include <string.h>
#include <stdio.h>
#include <stdlib.h>

/* file_t info items */
#define FILE_T_OFFSET 0

#define HEADER_SIZE 20

typedef struct header_sector {
	char name[MAX_FILENAME];
	unsigned int size;
	unsigned int next;
} __attribute__((__packed__)) sector_t;

/* Read sector header */
void read_header(unsigned int sector, struct header_sector *h)
{
	uint8_t buffer[SECTOR_SIZE];
	uint8_t head[HEADER_SIZE];
	struct header_sector *header;

	hdd_read(sector, buffer);
	memcpy(head, buffer, sizeof(struct header_sector));

	header = ((struct header_sector *)head);
	strcpy(h->name, header->name);
	h->size = header->size;
	h->next = header->next;
}

/* Write sector header */
void write_sector_header(unsigned int sector, struct header_sector *h)
{
	uint8_t buffer[SECTOR_SIZE] = {0};
	hdd_read(sector, buffer);
	memcpy(buffer, h, sizeof(struct header_sector));
	
	hdd_write(sector, buffer);
}

unsigned int exists(const char *path)
{
	unsigned int curr_sec = 0;
	struct header_sector h;
	while (curr_sec < hdd_size() / SECTOR_SIZE) {
		read_header(curr_sec, &h);

		if (!strncmp(h.name, path, MAX_FILENAME)) {
			return curr_sec;
		}
		if (h.next == 0) {
			return 0;
		}

		curr_sec = h.next;
	}
	return 0;
}

void shorten(unsigned int sector)
{
	struct header_sector h;
	read_header(sector, &h);
	h.size = 0;
	write_sector_header(sector, &h);
}


/**
 * Naformatovanie disku.
 *
 * Zavola sa vzdy, ked sa vytvara novy obraz disku. Mozete predpokladat, ze je
 * cely vynulovany.
 */
void fs_format()
{
	struct header_sector h;
	strcpy(h.name, "---");
	h.size = 0;
	h.next = 0;
	write_sector_header(0, &h);
}

/**
 * Vytvorenie suboru.
 *
 * Volanie vytvori v suborovom systeme na zadanej ceste novy subor a vrati
 * handle nan. Ak subor uz existoval, bude skrateny na 0. Pozicia v subore bude
 * nastavena na 0ty byte. Ak adresar, v ktorom subor ma byt ulozeny neexistuje,
 * vrati FAIL (sam nevytvara adresarovu strukturu, moze vytvarat iba subory).
 */
file_t *fs_creat(const char *path)
{
	/* Nepodporujeme adresare */
	if (strrchr(path, PATHSEP) != path)
		return (file_t*)FAIL;

	unsigned int pos = exists(path);
	if (pos) {
		shorten(pos);
		printf("EXISTS\n");
		return fs_open(path);
	}
		
	struct header_sector current;
	unsigned int curr_sec = 0;
	while (1) {
		read_header(curr_sec, &current);

		if (current.next == 0 && curr_sec != (hdd_size() / SECTOR_SIZE) - 1) {
			break;
		} else if (current.next == 0) {
			return (file_t *)FAIL;
		}

		if (current.next - curr_sec > 1) {
			break;
		}
		curr_sec = current.next;
	}

	struct header_sector newh;
	strcpy(newh.name, path);
	newh.size = 0;
	newh.next = current.next;
	
	current.next = curr_sec + 1;
	
	write_sector_header(curr_sec+1, &newh);
	write_sector_header(curr_sec, &current);

	return fs_open(path);
}


/**
 * Otvorenie existujuceho suboru.
 *
 * Ak zadany subor existuje funkcia ho otvori a vrati handle nan. Pozicia v
 * subore bude nastavena na 0ty bajt. Ak subor neexistuje, vrati FAIL. Struktura
 * file_t sa musi alokovat jedine pomocou fd_alloc.
 */
file_t *fs_open(const char *path)
{
	file_t *fd;

	unsigned int pos = exists(path);
	if (!pos)
		return (file_t*)FAIL;

	fd = fd_alloc();

	fd->info[FILE_T_OFFSET] = pos; /* File's sector	*/
	fd->info[1] = 0; /* position in file */
	fd->info[2] = 0;
	fd->info[3] = 0;

	return fd;
}

/**
 * Zatvori otvoreny file handle.
 *
 * Funkcia zatvori handle, ktory bol vytvoreny pomocou volania 'open' alebo
 * 'creat' a uvolni prostriedky, ktore su s nim spojene. V pripade akehokolvek
 * zlyhania vrati FAIL. Struktura file_t musi byt uvolnena jedine pomocou
 * fd_free.
 */
int fs_close(file_t *fd)
{
	/* Uvolnime filedescriptor, aby sme neleakovali pamat */
	fd_free(fd);
	return OK;
}

/**
 * Odstrani subor na ceste 'path'.
 *
 * Ak zadana cesta existuje a je to subor, odstrani subor z disku; nemeni
 * adresarovu strukturu. V pripade chyby vracia FAIL.
 */
int fs_unlink(const char *path)
{
	unsigned int pos = exists(path);
	if (!pos)
		return FAIL;

	struct header_sector tounlink;
	read_header(pos, &tounlink);
	
	unsigned int curr_sec = 0;
	struct header_sector prev;
	while (1) {
		read_header(curr_sec, &prev);
		if (prev.next == pos) {
			break;
		}
		curr_sec = prev.next;
	}

	prev.next = tounlink.next;
	write_sector_header(curr_sec, &prev);
	return OK;
}

/**
 * Premenuje/presunie polozku v suborovom systeme z 'oldpath' na 'newpath'.
 *
 * Po uspesnom vykonani tejto funkcie bude subor, ktory doteraz existoval na
 * 'oldpath' dostupny cez 'newpath' a 'oldpath' prestane existovat. Opat,
 * funkcia nemanipuluje s adresarovou strukturou (nevytvara nove adresare z cesty newpath okrem posledneho).
 * V pripade zlyhania vracia FAIL.
 */
int fs_rename(const char *oldpath, const char *newpath)
{
	unsigned int pos = exists(oldpath);
	if (!pos)
		return FAIL;

	struct header_sector torename;
	read_header(pos, &torename);
	strcpy(torename.name, newpath);
	write_sector_header(pos, &torename);
	return OK;
}

/**
 * Nacita z aktualnej pozicie vo 'fd' do bufferu 'bytes' najviac 'size' bajtov.
 *
 * Z aktualnej pozicie v subore precita funkcia najviac 'size' bajtov; na konci
 * suboru funkcia vracia 0. Po nacitani dat zodpovedajuco upravi poziciu v
 * subore. Vrati pocet precitanych bajtov z 'bytes', alebo FAIL v pripade
 * zlyhania. Existujuci subor prepise.
 */
int fs_read(file_t *fd, uint8_t *bytes, unsigned int size)
{
	/* Podporujeme iba subory s maximalnou velkostou SECTOR_SIZE */
	uint8_t buffer[SECTOR_SIZE] = { 0 };

	/* Vo filedescriptore je ulozena nasa aktualna pozicia v subore */
	int sector = fd->info[FILE_T_OFFSET];
	int offset = fd->info[FILE_T_OFFSET+1] + HEADER_SIZE;

	struct header_sector h;
	read_header(sector, &h);

	/* Nacitame cely suboru na disku */
	hdd_read(sector, buffer);

	int i;
	for (i = 0; (i < size) && ((i + offset) < h.size); i++) {
		bytes[i] = buffer[offset + i];
	}	

	/* Aktualizujeme offset, na ktorom sme teraz */
	fd->info[FILE_T_OFFSET+1] += i;

	/* Vratime pocet precitanych bajtov */
	return i;
}

/**
 * Zapise do 'fd' na aktualnu poziciu 'size' bajtov z 'bytes'.
 *
 * Na aktualnu poziciu v subore zapise 'size' bajtov z 'bytes'. Ak zapis
 * presahuje hranice suboru, subor sa zvacsi; ak to nie je mozne, zapise sa
 * maximalny mozny pocet bajtov. Po zapise korektne upravi aktualnu poziciu v
 * subore a vracia pocet zapisanych bajtov z 'bytes'.
 */
int fs_write(file_t *fd, const uint8_t *bytes, unsigned int size)
{
	uint8_t buffer[SECTOR_SIZE] = { 0 };
	
	/* Vo filedescriptore je ulozena nasa aktualna pozicia v subore */
	int sector = fd->info[FILE_T_OFFSET];
	int offset = fd->info[FILE_T_OFFSET+1] + HEADER_SIZE;

	struct header_sector h;
	read_header(sector, &h);

	/* Nacitame cely sektor suboru z disku */
	hdd_read(sector, buffer);

	int i;
	for (i = 0; (i < size) && ((i + offset) < SECTOR_SIZE); i++) {
		buffer[offset + i] = bytes[i];
	}
	hdd_write(sector, buffer);

	/* Ak subor narastol, aktualizujeme velkost */
	if (h.size < offset + i) {
		h.size = offset + i;
		write_sector_header(sector, &h);
	}

	/* Aktualizujeme offset, na ktorom sme */
	fd->info[FILE_T_OFFSET+1] += i;

	/* Vratime pocet precitanych bajtov */
	return i;
}

/**
 * Zmeni aktualnu poziciu v subore na 'pos'-ty byte.
 *
 * Upravi aktualnu poziciu; ak je 'pos' mimo hranic suboru, vrati FAIL a pozicia
 * sa nezmeni, inac vracia OK.
 */
int fs_seek(file_t *fd, unsigned int pos)
{
	uint8_t buffer[SECTOR_SIZE] = { 0 };
	int file_size;

	struct header_sector h;
	read_header(fd->info[FILE_T_OFFSET], &h);

	/* Nemozeme seekovat za velkost suboru */
	if (pos > h.size) {
		fprintf(stderr, "Can not seek: %d > %d\n", pos, h.size);
		return FAIL;
	}

	fd->info[FILE_T_OFFSET+1] = pos;

	return OK;
}


/**
 * Vrati aktualnu poziciu v subore.
 */
unsigned int fs_tell(file_t *fd)
{
	return fd->info[FILE_T_OFFSET+1];
}


/**
 * Vrati informacie o 'path'.
 *
 * Funkcia vrati FAIL ak cesta neexistuje, alebo vyplni v strukture 'fs_stat'
 * polozky a vrati OK:
 *  - st_size: velkost suboru v byte-och
 *  - st_nlink: pocet hardlinkov na subor (ak neimplementujete hardlinky, tak 1)
 *  - st_type: hodnota podla makier v hlavickovom subore: ST_TYPE_FILE,
 *  ST_TYPE_DIR, ST_TYPE_SYMLINK
 *
 */
int fs_stat(const char *path, struct fs_stat *fs_stat)
{ 
	int file_size;
	struct header_sector file_stats;

	unsigned int pos = exists(path);
	if (!pos)
		return FAIL;

	read_header(pos, &file_stats);
	fs_stat->st_size = file_stats.size;
	fs_stat->st_nlink = 1;
	fs_stat->st_type = ST_TYPE_FILE;

	return OK; 
};

/* Level 3 */
/**
 * Vytvori adresar 'path'.
 *
 * Ak cesta, v ktorej adresar ma byt, neexistuje, vrati FAIL (vytvara najviac
 * jeden adresar), pri korektnom vytvoreni OK.
 */
int fs_mkdir(const char *path) { return FAIL; };

/**
 * Odstrani adresar 'path'.
 *
 * Odstrani adresar, na ktory ukazuje 'path'; ak neexistuje alebo nie je
 * adresar, vrati FAIL; po uspesnom dokonceni vrati OK.
 */
int fs_rmdir(const char *path) { return FAIL; };

/**
 * Otvori adresar 'path' (na citanie poloziek)
 *
 * Vrati handle na otvoreny adresar s poziciou nastavenou na 0; alebo FAIL v
 * pripade zlyhania.
 */
file_t *fs_opendir(const char *path) { return (file_t*)FAIL; };

/**
 * Nacita nazov dalsej polozky z adresara.
 *
 * Do dodaneho buffera ulozi nazov polozky v adresari a posunie aktualnu
 * poziciu na dalsiu polozku. V pripade problemu, alebo nemoznosti precitat
 * polozku (dalsia neexistuje) vracia FAIL.
 */
int fs_readdir(file_t *dir, char *item) {return FAIL; };

/** 
 * Zatvori otvoreny adresar.
 */
int fs_closedir(file_t *dir) { return FAIL; };

/* Level 4 */
/**
 * Vytvori hardlink zo suboru 'path' na 'linkpath'.
 */
int fs_link(const char *path, const char *linkpath) { return FAIL; };

/**
 * Vytvori symlink z 'path' na 'linkpath'.
 */
int fs_symlink(const char *path, const char *linkpath) { return FAIL; };

