#include "wrapper.h"

#define HEADER_SIZE 8

struct header {
	unsigned int next;
	unsigned int end;
};

uint8_t get_byte(uint8_t which, unsigned int number)
{
	return (uint8_t)((number >> (24-(which*8))) & 0xff);
}

unsigned int join_bytes(uint8_t b1, uint8_t b2, uint8_t b3, uint8_t b4)
{
	return (unsigned int)((b1 << 24) | (b2 << 16) | (b3 << 8) | b4);
}

/* Read header starting at `addr` address */
struct header read_header(unsigned int addr)
{
	struct header h;
	h.next = join_bytes(mread(addr), mread(addr+1), mread(addr+2), mread(addr+3));
	h.end = join_bytes(mread(addr+4), mread(addr+5), mread(addr+6), mread(addr+7));
	return h;
}

/* Write header to memory at address `addr` */
void write_header(unsigned int addr, struct header write)
{
	mwrite(addr, get_byte(0, write.next));
	mwrite(addr+1, get_byte(1, write.next));
	mwrite(addr+2, get_byte(2, write.next));
	mwrite(addr+3, get_byte(3, write.next));

	mwrite(addr+4, get_byte(0, write.end));
	mwrite(addr+5, get_byte(1, write.end));
	mwrite(addr+6, get_byte(2, write.end));
	mwrite(addr+7, get_byte(3, write.end));
}


/**
 * Inicializacia pamate
 *
 * Zavola sa, v stave, ked sa zacina s prazdnou pamatou, ktora je inicializovana
 * na 0.
 */
void my_init(void)
{
	struct header h = {0, HEADER_SIZE-1};
	write_header(0, h);
}

/**
 * Poziadavka na alokaciu 'size' pamate. 
 *
 * Ak sa pamat podari alokovat, navratova hodnota je adresou prveho bajtu
 * alokovaneho priestoru v RAM. Pokial pamat uz nie je mozne alokovat, funkcia
 * vracia FAIL.
 */
int my_alloc(unsigned int size)
{
	/* Nemozeme alokovat viac pamate, ako je dostupne alebo zaporne */
	if (size > msize() - (2*HEADER_SIZE) || size <= 0)
		return FAIL;

	struct header newh;
	struct header current;

	unsigned int curr_addr = 0;
	while (1) {
		current = read_header(curr_addr);

		/* Check for free space behind this last block in memory */
		if (current.next == 0 && msize() - current.end > size + HEADER_SIZE) {
			current.next = current.end + 1;
			write_header(curr_addr, current);
			newh.next = 0;
			newh.end = current.next + HEADER_SIZE + size - 1;
			write_header(current.next, newh);
			return current.next + HEADER_SIZE;
		} else if (current.next == 0){
			break;
		}

		/* Check for space between 2 blocks */
		if (current.next - current.end > size + HEADER_SIZE) {
			newh.next = current.next;
			newh.end = current.end + size + HEADER_SIZE;
			current.next = current.end + 1;
			write_header(curr_addr, current);
			write_header(current.next, newh);
			return current.next + HEADER_SIZE;
		}

		curr_addr = current.next;
	}

	return FAIL;
}

/**
 * Poziadavka na uvolnenie alokovanej pamate na adrese 'addr'.
 *
 * Ak bola pamat zacinajuca na adrese 'addr' alokovana, my_free ju uvolni a
 * vrati OK. Ak je adresa 'addr' chybna (nezacina na nej ziadna alokovana
 * pamat), my_free vracia FAIL.
 */
int my_free(unsigned int addr)
{
	/* Incorrect address */
	if (addr >= msize() || addr < HEADER_SIZE)
		 return FAIL;

	struct header current;
	struct header dealloc;

	unsigned int curr_addr = 0;
	while (1) {
		current = read_header(curr_addr);

		/* There is not such a block */
		if (current.next == 0 || curr_addr >= addr)
			break;

		/* Check if we found block to be deallocated */
		if (current.next + HEADER_SIZE == addr) {
			dealloc = read_header(current.next);
			current.next = dealloc.next;
			write_header(curr_addr, current);
			return OK;
		}

		curr_addr = current.next;
	}

	return FAIL;
}
