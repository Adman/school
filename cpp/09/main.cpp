/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on November 24, 2015, 8:24 PM
 */

#include <iostream>
#include <cmath>
#include <cstdio>

using namespace std;

/* Struct representing the current status of each player */
struct player {
    int current_point = 0;
    int x;
    int y;
    bool finished = false;
};

/* Position of each station */
struct station {
    int x;
    int y;
};

int main(void)
{
    int S; /* Number of stations*/
    int P; /* Number of players */
    int N; /* Field size N*N */
    int K; /* Number of laps */
    int players_finished = 0; /* How many players already finished */
    
    cin >> S >> P >> N >> K;
    
    station *stations = new station[S];
    for (int i = 0; i < S; i++) {
        cin >> stations[i].x >> stations[i].y;
    }
    
    player *players = new player[P];
    for (int i = 0; i < P; i++) {
        players[i].x = stations[0].x;
        players[i].y = stations[0].y;
    }
    
    int *finished = new int[P];
    
    int x_move;
    int y_move;
    
    /* Simulate all the laps and print occupied points */
    for (int lap = 0; lap < K; lap++) {
        printf("Aktualne stanovistia po %d. kole:", lap+1);

        for (int p = 0; p < P; p++) {
            cin >> x_move >> y_move;
            int x_step = x_move < 0 ? -1 : (x_move == 0 ? 0 : 1);
            int y_step = y_move < 0 ? -1 : (y_move == 0 ? 0 : 1);
            
            /* Move player vertically/horizontally based on vector given
             * In case he has already reached finish, do not waste time moving him */
            for (int step = 0; step < abs(x_move+y_move); step++) {
                if (!players[p].finished) {
                    players[p].x += x_step;
                    players[p].y += y_step;
                    
                    if (players[p].x == stations[players[p].current_point + 1].x &&
                            players[p].y == stations[players[p].current_point + 1].y) {
                        players[p].current_point++;
                    }
                    
                    if (players[p].current_point == S-1) {
                        players[p].finished = true;
                        finished[players_finished++] = p;
                    }
                } else {
                    break;
                }
            }
            printf(" %d", players[p].current_point);
        }
        printf("\n");
    }
    
    /* Print the results and also the players that have not finished */
    for (int i = 0; i < players_finished; i++) {
        printf("%d. skoncil pretekar %d\n", i+1, finished[i]);
    }
    
    if (P - players_finished != 0) {
        printf("Neuspesni:");
        for (int i = 0; i < P; i++)
            if (!players[i].finished)
                printf(" %d", i);
        printf("\n");
    }

    delete[] players;
    delete[] stations;
    delete[] finished;
    
    return 0;
}