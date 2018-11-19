#include <iostream>
#include <algorithm>
#include <unordered_set>
#include <math.h>
#include <chrono>
#include <emmintrin.h>
#include <smmintrin.h>
#include <immintrin.h>
#include <random>

using namespace std;
using namespace std::chrono;

const int size = 160000;/* should be divisible by 16 */
const int N = 140000;
const int num_groups = size / 16;

const uint8_t empty = 128;

inline long long H1(long long hash)
{
    return hash >> 7;
}

inline uint8_t H2(long long hash)
{
    return (uint8_t)(hash & 127);
}

inline long long get_hash(long long x)
{
    return x % size;
}

uint16_t match(uint8_t hash, uint8_t ctrl[], long long group_start)
{
    return (uint16_t)_mm_movemask_epi8(_mm_cmpeq_epi8(_mm_set1_epi8(hash),
                                              _mm_loadu_si128((__m128i *)&ctrl[group_start])));
}

long long find(long long x, uint8_t ctrl[], long long arr[])
{
    long long hash = get_hash(x);
    long long group = H1(hash) % num_groups;
    uint8_t h2hash = H2(hash);
    while(true) {
        long long group_start = 16*group;

        uint16_t mask = match(h2hash, ctrl, group_start);
        while (mask > 0) {
            /* taken from https://www.geeksforgeeks.org/position-of-rightmost-set-bit */
            int bit = log2(mask & -mask) + 1;
            if (x == arr[group_start + bit-1])
                return group_start + bit-1;
            mask = mask & (mask - 1);
        }

        if (match(empty, ctrl, group_start))
            return -1;
        group = (group + 1) % num_groups;
    }
}

void insert(long long x, uint8_t ctrl[], long long arr[])
{
    long long hash = get_hash(x);
    long long group = H1(hash) % num_groups;
    long long pos = 0;
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
    uint8_t ctrl[size+16];
    long long arr[size+16];

    long long values[N];

    fill_n(ctrl, size, empty);
    fill_n(arr, size, -1);

    unordered_set<long long> uset;

    auto t1 = 0;
    auto t2 = 0;

    /* generate random numbers*/
    for (long long i = 0; i < N; i++)
        values[i] = ((long long)rand() << 32) | rand();

    /* insert numbers 0,...,N-1 with step 2*/
    for (long long i = 0; i < N; i++) {
        insert(values[i], ctrl, arr); 
        uset.insert(values[i]);
    }

    for (long long i = 0; i < N; i++) {
        auto t11 = high_resolution_clock::now();
        find(values[i], ctrl, arr);
        auto t12 = high_resolution_clock::now();

        auto t21 = high_resolution_clock::now();
        uset.find(values[i]);
        auto t22 = high_resolution_clock::now();

        t1 += duration_cast<microseconds>(t12 - t11).count();
        t2 += duration_cast<microseconds>(t22 - t21).count();
    }

    cout << "Flat_hash_set: Total: " << t1 << " Avg: " << t1/N << endl;
    cout << "Unordered set: Total: " << t2 << " Avg: " << t2/N << endl;
    return 0;
}
