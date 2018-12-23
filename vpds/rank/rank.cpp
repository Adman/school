#include <chrono>
#include <iostream>
#include <cstdlib>
#include <inttypes.h>
#include <vector>

using namespace std;
using namespace std::chrono;

const int QUERIES = 5000;


void compute_trivial(uint64_t n, vector<uint64_t> &tr, int &j, uint64_t &ones)
{
    for (int i = 0; i < 64; i++) {
        if ((1UL << (63-i)) & n)
            ones++;

        tr[j++] = ones;
    }
}

uint64_t bitrank(uint64_t i, vector<uint64_t> &bs)
{
    uint64_t iblock = i / 64;
    uint64_t prev_headers = (iblock / 7) + 1;
    uint64_t block = iblock + prev_headers;
    uint64_t header = (prev_headers - 1) * 8;
    uint64_t new_i = i + 64*prev_headers;

    uint64_t result = 0;

    uint64_t read = header + 1;
    uint64_t block_end_pos = header*512 + 128;
    int popcounts = 0;
    /* max 7 popcounts */
    while (read < block) {
        result += __builtin_popcountll(bs[read++]);
        popcounts++;
        block_end_pos += 64;
    }

    /* last special popcount */
    /* slow if - not sure if removable */
    if (popcounts < 7)
        result += __builtin_popcountll(bs[read] >> (block_end_pos - new_i - 1));

    return bs[header] + result;
}

uint64_t rank_trivial(uint64_t i, vector<uint64_t> &trivial)
{
    return trivial[i];
}

int main(int argc, char** argv)
{
    srand(time(NULL));

    vector<uint64_t> bs;
    vector<uint64_t> trivial;


    for (int BLOCKS = 100000; BLOCKS < 1000001; BLOCKS += 100000) {
        uint64_t N = 7 * BLOCKS;
        bs.resize(N + BLOCKS);
        trivial.resize(64 * N);

        uint64_t ones = 0;
        uint64_t ones_trivial = 0;
        int j = 0;
        for (uint64_t i = 0; i < N + BLOCKS; i++) {
            /* header */
            if (i % 8 == 0) {
                /*compute previous */
                bs[i] = ones;
            } else {
                bs[i] = ((uint64_t)rand() << 32) | rand();
                ones += __builtin_popcountll(bs[i]);
                compute_trivial(bs[i], trivial, j, ones_trivial);
            }
        }

        /* generate random queries */
        uint64_t queries[QUERIES];
        for (int i = 0; i < QUERIES; i++)
            queries[i] = (((uint64_t)rand() << 32) | rand()) % (N*64);

        
        /* measure our bitrank */
        uint64_t times = 0;
        uint64_t rank_sum = 0;
        for (int repeats = 0; repeats < 5; repeats++) {
            auto s = high_resolution_clock::now();
            for (int j = 0; j < QUERIES; j++) {
                rank_sum = bitrank(queries[j], bs);
            }
            auto e = high_resolution_clock::now();
            times += duration_cast<nanoseconds>(e - s).count();
        }

        /* measure trivial bitrank */
        uint64_t times2 = 0;
        rank_sum = 0;
        for (int repeats = 0; repeats < 5; repeats++) {
            auto s = high_resolution_clock::now();
            for (int j = 0; j < QUERIES; j++) {
                rank_sum = rank_trivial(queries[j], trivial);
            }
            auto e = high_resolution_clock::now();
            times2 += duration_cast<nanoseconds>(e - s).count();
        }

        /* bits, time bitrank, time trivial, sum */
        cout << N*64 << " " << times << " " << times2 << " " << rank_sum << endl;
    }
    
    return 0;
}
