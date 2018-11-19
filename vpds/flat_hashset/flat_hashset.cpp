#include <iostream>
#include <stdint.h>
#include <algorithm>
#include <unordered_set>
#include <math.h>
#include <chrono>
#include <emmintrin.h>
#include <random>

using namespace std;
using namespace std::chrono;

const int size = 104000; /* should be divisible by 16 */
const int num_groups = size / 16;

const uint8_t empty = 128;

inline unsigned long long H1(unsigned long long hash)
{
    return hash >> 7;
}

inline uint8_t H2(unsigned long long hash)
{
    return (uint8_t)(hash & 127);
}

inline unsigned long long get_hash(unsigned long long x)
{
    return x % size;
}

uint32_t match(uint8_t hash, uint8_t *ctrl, unsigned long long group_start)
{
    return _mm_movemask_epi8(_mm_cmpeq_epi8(_mm_set1_epi8(hash),
                                            *(__m128i *)&ctrl[group_start]));
}

long long find(unsigned long long x, uint8_t *ctrl, unsigned long long *arr)
{
    unsigned long long hash = get_hash(x);
    unsigned long long group = H1(hash) % num_groups;
    uint8_t h2hash = H2(hash);
    while(true) {
        unsigned long long group_start = 16*group;

        uint32_t mask = match(h2hash, ctrl, group_start);
        while (mask > 0) {
            /* taken from https://www.geeksforgeeks.org/position-of-rightmost-set-bit */
            int bit = log2(mask & -mask);
            if (x == arr[group_start + bit])
                return group_start + bit;
            mask = mask & (mask - 1);
        }

        if (match(empty, ctrl, group_start))
            return -1;
        group = (group + 1) % num_groups;
    }
}

void insert(unsigned long long x, uint8_t *ctrl, unsigned long long *arr)
{
    unsigned long long hash = get_hash(x);
    unsigned long long group = H1(hash) % num_groups;
    unsigned long long pos = 0;
    while(true) {    
        if (ctrl[(16*group + pos) % size] == empty) {
            ctrl[(16*group + pos) % size] = H2(hash);
            arr[(16*group + pos) % size] = x;
            return;
        }
        pos++;
    }
}

int main(int argc, char** argv)
{
    srand(time(NULL));

    uint8_t *ctrl __attribute__((aligned(16))) = new uint8_t[size+16];
    unsigned long long *arr = new unsigned long long[size+16];

    unsigned long long *values = new unsigned long long[size];
    unordered_set<unsigned long long> uset;
    
    for (unsigned long long ELEMENTS = 50000; ELEMENTS <= 100000; ELEMENTS += 10000) {
        cout << "Testing load factor " << (double)ELEMENTS/size << endl;
        fill_n(ctrl, size, empty);
        fill_n(arr, size, -1);

        uset.clear();

        auto t1 = 0;
        auto t2 = 0;

        /* generate random numbers*/
        for (unsigned long long i = 0; i < ELEMENTS; i++)
            values[i] = ((unsigned long long)rand() << 32) | rand();

        /* insert numbers 0,...,ELEMENTS-1 with step 2*/
        for (unsigned long long i = 0; i < ELEMENTS; i++) {
            insert(values[i], ctrl, arr); 
            uset.insert(values[i]);
        }

        for (unsigned long long i = 0; i < ELEMENTS; i++) {
            auto t11 = high_resolution_clock::now();
            find(values[i], ctrl, arr);
            auto t12 = high_resolution_clock::now();
            
            t1 += duration_cast<microseconds>(t12 - t11).count();
        }

        
        for (unsigned long long i = 0; i < ELEMENTS; i++) {
            auto t21 = high_resolution_clock::now();
            uset.find(values[i]);
            auto t22 = high_resolution_clock::now();
           
            t2 += duration_cast<microseconds>(t22 - t21).count();
        }

        cout << "Flat_hash_set: Total: " << t1 << " Avg: " << (double)t1/ELEMENTS << endl;
        cout << "Unordered set: Total: " << t2 << " Avg: " << (double)t2/ELEMENTS << endl;
    }
    return 0;
}
