#include <iostream>
#include <stdint.h>
#include <algorithm>
#include <unordered_set>
#include <math.h>
#include <chrono>
#include <emmintrin.h>
#include <smmintrin.h>
#include <immintrin.h>

using namespace std;
using namespace std::chrono;

const int size = 160000;/* should be divisible by 16 */
const int N = 140000;
const int num_groups = size / 16;

const uint8_t empty = 128;

inline int64_t H1(int64_t hash)
{
    return hash >> 7;
}

inline uint8_t H2(int64_t hash)
{
    return (uint8_t)(hash & 127);
}

inline int64_t get_hash(int64_t x)
{
    return x % size;
}

uint16_t match(uint8_t hash, uint8_t ctrl[], int64_t group_start)
{
    return (uint16_t)_mm_movemask_epi8(_mm_cmpeq_epi8(_mm_set1_epi8(hash),
                                              _mm_loadu_si128((__m128i *)&ctrl[group_start])));
}

int64_t find(int64_t x, uint8_t ctrl[], int64_t arr[])
{
    int64_t hash = get_hash(x);
    int64_t group = H1(hash) % num_groups;
    uint8_t h2hash = H2(hash);
    while(true) {
        int64_t group_start = 16*group;

        uint16_t mask = match(h2hash, ctrl, group_start);
        while (mask > 0) {
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

void insert(int64_t x, uint8_t ctrl[], int64_t arr[])
{
    int64_t hash = get_hash(x);
    int64_t group = H1(hash) % num_groups;
    int64_t pos = 0;
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
    int64_t arr[size+16];

    fill_n(ctrl, size, empty);
    fill_n(arr, size, -1);

    unordered_set<int64_t> uset;

    auto t1 = 0;
    auto t2 = 0;

    /* insert numbers 0,...,N-1 with step 2*/
    for (int64_t i = 1000; i < 1000+N; i += 2) {
        insert(i, ctrl, arr); 
        uset.insert(i);
    }

    for (int64_t i = 1000; i < 1000+N; i++) {
        auto t11 = high_resolution_clock::now();
        find(i, ctrl, arr);
        auto t12 = high_resolution_clock::now();

        auto t21 = high_resolution_clock::now();
        uset.find(i);
        auto t22 = high_resolution_clock::now();

        t1 += duration_cast<microseconds>(t12 - t11).count();
        t2 += duration_cast<microseconds>(t22 - t21).count();
    }

    cout << "Flat_hash_set: Total: " << t1 << " Avg: " << t1/N << endl;
    cout << "Unordered set: Total: " << t2 << " Avg: " << t2/N << endl;
    return 0;
}
