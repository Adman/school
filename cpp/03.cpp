/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on October 7, 2015, 5:06 PM
 */

#include <iostream>
#include <iomanip>
#include <cassert>

using namespace std;

const int MAXS = 100;  /* maximal number of lines */
const int MAXN = 100;  /* maximal number of stations */

/* Struct containing exact hour and minute of departure.
 * hour is from 0 to 23 and minute is from 0 to 59 */
struct departure {
    int hour, minute;
};

/* Output helper which takes care of number to be 2 digit number */
void print_value(int value)
{
    assert(0 <= value && value < 60);
    cout << setfill('0') << setw(2) << value;
}

/* Print times of all departures from the station
 * Also includes non-departure hours marked with - */
void print_departures(int nlines, departure st[])
{   
    int prev_hour = -1;
    int j;

    for (int i = 0; i < nlines; i++) {
        if (st[i].hour != prev_hour) {
            if (st[i].hour - 1 > prev_hour && prev_hour != -1) {
                for (j = prev_hour+1; j < st[i].hour; j++) {
                    cout << endl;
                    print_value(j);
                    cout << ": -";
                }
                cout << endl;
            } else if (prev_hour != -1)
                cout << endl;

            prev_hour = st[i].hour;
            print_value(st[i].hour);
            cout << ":";
        }
        cout << " ";
        print_value(st[i].minute);
    }
    cout << endl << endl;
}

/* Funkcia dostane struct odjazdov, v ktorom je C časov
 * a ku každému času pripočíta hodnotu M minút,
 * pričom správne ošetrií aj posun hodiny, ak treba.
 * M je vždy kladné číslo, ale môže byť väčšie ako 60.
 * Výsledný čas bude vždy pred polnocou toho istého dňa
 * ako pôvodná hodnota. */
void count_departures(int minutes, departure st[], int nlines)
{
    for (int i = 0; i < nlines; i++) {
        st[i].minute += minutes;
        
        if (st[i].minute > 59) {
            st[i].hour += st[i].minute / 60;
            st[i].minute %= 60;
        }
    }
}

/* Prints how long it takes to get to next stations */
void travel_time_to_next_stations(int station, int times[], int nstations)
{
    int i, j;
    int sum_time;
    
    cout << "Doba jazdy na dalsie zastavky:";

    for (int i = station+1; i < nstations; i++) {
        sum_time = times[station+1];
        for (j = station+2; j <= i; j++) {
            sum_time += times[j];
        }
        cout << " " << sum_time;
    }
    cout << endl;
}

/*
 * Prints info current station
 */
void station_output(int station, int times[], int nstations, int nlines,
        departure st[])
{    
    count_departures(times[station], st, nlines);

    cout << "Zastavka " << station << endl;

    if (station == nstations-1)
        cout << "Konecna zastavka" << endl;
    else
        travel_time_to_next_stations(station, times, nstations);

    print_departures(nlines, st);
}

int main(void)
{
    int i;
    int nstations;
    int nlines;
    int times[MAXN];
    departure st[MAXS];    
    
    /* Read how many stations are there */
    cin >> nstations;
    
    /* Read numbers which determine the time to get from the first stations to
     * another */
    times[0] = 0;
    for (i = 1; i < nstations; i++) {
        cin >> times[i];
    }
    
    /* Read the number of lines departed per day */
    cin >> nlines;
    
    /* Read the time of each departure */
    for (i = 0; i < nlines; i++) {
        cin >> st[i].hour >> st[i].minute;
    }
    
    for (i = 0; i < nstations; i++) {
        station_output(i, times, nstations, nlines, st);
    }

    return 0;
}