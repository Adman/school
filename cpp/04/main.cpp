/* 
 * File:   main.cpp
 * inputhor: adman
 *
 * Created on October 14, 2015, 10:52 PM
 */

#include <iostream>
#include <cstring>
#include <cassert>

using namespace std;

/* Replaces multispaced area just with 1 space and removes all the other
 * messy whitespaces */
void simplify(char inp[])
{
    /* prepis hocijake biele znaky na medzeru */
    for (int i = 0; inp[i] != 0; i++) {
        if (isspace(inp[i])) {
            inp[i] = ' ';
        }
    }

    int kam = 0; /* prve este neobsadene miesto */
    char prev = ' '; /* predchadzajuci znak */

    for (int i = 0; inp[i] != 0; i++) {
        /* ak nemame viac medzier po sebe, skopirujeme znak */
        if (inp[i] != ' ' || prev != ' ') {
            inp[kam] = inp[i];
            kam++;
        }
        /* zapamatame si posledny znak */
        prev = inp[i];
    }

    /* zrusime pripadnu medzeru na konci */
    if (kam > 0 && inp[kam - 1] == ' ') {
        kam--;
    }

    /* retazec ukoncime nulou */
    inp[kam] = 0;
}

/* Tries to put as many words into one line as possible */
bool break_lines(char inp[], int width)
{
    simplify(inp);
    int n = strlen(inp);

    int zac = 0;  /* index prveho pismena v riadku */
    while (zac < n) {
        int kon = zac + width;  /* potencialny koniec riadku */
        /* ak uz nemame dost pismen na cely riadok */
        if (kon > n) {
            kon = n;
        }
        /* ak sme na konci, pridame koniec riadku za koniec retazca */
        if (kon == n) {
            inp[kon] = '\n';
            inp[kon + 1] = 0;
            n++;
        } else {
            /* ideme späť, kým nenájdeme medzeru */
            while (kon > zac && inp[kon] != ' ') {
                kon--;
            }
            /* nenašli sme medzeru: slovo bolo príliš dlhé. */
            if (kon == zac) {
                return false;
            }
            /* medzeru prepíšeme na koniec riadku */
            assert(inp[kon]==' ');
            inp[kon] = '\n';
        }
        /* za koncom riadku bude novy zaciatok */
        zac = kon + 1;
    }
    return true;
}

/* Counts spaces and return number of words */
int get_word_count(char inp[], int &from, int &chars)
{
    int count = 0;
    chars = 0;
    while (inp[from] != '\n') {
        if (inp[from] == ' ')
            count++;
        else
            chars++;
        from++;
    }
    from++;
    return count+1;
}

/* Returns the number of lines we have to format */
int get_line_count(char inp[])
{
    int i = 0;
    int count = 0;

    while (inp[i] != 0) {
        if (inp[i] == '\n')
            count++;
        i++;
    }
    return count;
}

/* Formats line to fit the width specified in input */
void format_line(char inp[], int i, int separators, int spaces)
{
    int current_sep = 1;
    int step_space = spaces / separators;
    int bigger_seps = spaces % separators;

    while (inp[i] != '\n') {
        if (inp[i] != ' ')
            cout << inp[i];
        else {
            for (int j = 0; j < ((current_sep <= bigger_seps) ? 
                    step_space+1 : step_space); j++) {
                cout << ' ';
            }
            current_sep++;
        }
        i++;
    }
    cout << endl;
}

/* Function goes through all the lines in the string and
 * calls format_line to each of them */
void process_data(char inp[], int width)
{
    int words;
    int spaces;
    int separators;
    int chars;
    int lines;
    int start = 0;
    int from = 0;
    
    lines = get_line_count(inp);

    for (int i = 0; i < lines - 1; i++) {
        words = get_word_count(inp, from, chars);
        separators = words - 1;
        spaces = width - chars;

        format_line(inp, start, separators, spaces);
        start = from;
    }
    
    /* Print last line which does not have to be formatted */
    while (inp[start] != 0)
        cout << inp[start++];
}

int main(void)
{
    const int MAXWIDTH = 2000;
    int width;
    char inp[MAXWIDTH];

    inp[0] = 0;

    /* read lines of text and copy it to inp array */
    while (true) {
        char tmp[MAXWIDTH];
        
        cin.getline(tmp, MAXWIDTH);

        if (strcmp(tmp, "") == 0) {
            break;
        }

        strcat(inp, tmp);
        strcat(inp, " ");
    }

    /* Read width of the output line */
    cin >> width;

    break_lines(inp, width);

    process_data(inp, width);
    
    return 0;
}

