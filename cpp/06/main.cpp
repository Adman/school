/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on October 29, 2015, 9:13 PM
 */

#include <iostream>
#include <cmath>

using namespace std;

/* Minimal number of transmitters to cover all the villages */
int min_trans = 0;
/* IDs of transmitters */
int ids[20];

/* Global constants which will be read from input 
 * Saving it to global because they would mess up the generate function */
double range;
int vils;

/* Struct containing x and y positions and specific ID of a village */
struct village {
    double x;
    double y;
    int id;
};

/* Check whether every village is covered by a transmitter */
bool are_villages_covered(village villages[], bool gen[], int current_trans)
{
    bool is_in;
    double x_v, y_v, x_t, y_t;
    
    for (int i = 0; i < vils; i++) {
        is_in = false;
        for (int j = 0; j < vils; j++) {
            if (gen[j]) {
                x_v = villages[i].x;
                y_v = villages[i].y;
                x_t = villages[j].x;
                y_t = villages[j].y;
                
                if (sqrt((x_v-x_t)*(x_v-x_t) + (y_v-y_t)*(y_v-y_t)) <= range) {
                    is_in = true;
                    break;
                }
            }
        }
        if (!is_in)
            return false;
    }
    return true;
}

/* Save transmitter IDs which covers all the villages */
void save_transmitters(village villages[], bool gen[])
{
    int index = 0;
    for (int i = 0; i < vils; i++) {
        if (gen[i])
            ids[index++] = villages[i].id;
    }
}

/* Generate all the subsets where transmitters might be placed
 * Choose the lowest number of them if they cover all the villages */
void generate(village villages[], bool gen[], int i, int current_trans)
{
    if (i == vils) {
        if (are_villages_covered(villages, gen, current_trans) &&
                current_trans != 0) {
            if (min_trans == 0 || min_trans > current_trans) {
                min_trans = current_trans;
                save_transmitters(villages, gen);
            }
        }
    } else {
        /* Stop generating cases that will certainly be bigger than previous ones */
        if (current_trans >= min_trans && min_trans != 0) 
            return;
        
        gen[i] = false;
        generate(villages, gen, i+1, current_trans);
        
        current_trans++;
        gen[i] = true;
        generate(villages, gen, i+1, current_trans);
    }
}

int main(void)
{
    bool gen[20] = {0};
    
    village villages[20];
    
    /* Read the number of villages and the range of each transmitter */
    cin >> vils >> range;
    
    /* Read the x and y positions of each village and assign ID */
    for (int i = 0; i < vils; i++) {
        cin >> villages[i].x >> villages[i].y;
        villages[i].id = i;
    }
    
    generate(villages, gen, 0, 0);
    
    /* Print minimal amount of transmitters and also their IDs */
    cout << min_trans << endl << ids[0];
    for (int i = 1; i < min_trans; i++)
        cout << " " << ids[i];
    
    cout << endl;

    return 0;
}