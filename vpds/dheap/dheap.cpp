#include <chrono>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <iostream>

using namespace std;
using namespace std::chrono;

const int D = 8;
const int N = 10000;

int get_parent(int index)
{
    int remainder = index % D;
    return index == 0 ? 0 : (remainder == 0 ? (index - D)/D : (index - remainder)/D);
}

int get_lowest_child(vector<int> h, int index)
{
    int lowest = index;
    int size = h.size();
    int last_child = D*index + D;
    for (int i = D*index + 1; i <= (size <= last_child ? size-1 : last_child); i++) {
        lowest = h[lowest] > h[i] ? i : lowest;
    }
    return lowest;
}


void insert(vector<int> &h, int index)
{
    /* we expect that from index to left the array is a valid heap */
    int parent = (index-1) / D;

    while (index > 0 && h[parent] > h[index]) {
        swap(h[parent], h[index]);
        index = parent;
        parent = (index-1) / D;
    }
}

int delete_min(vector<int> &h)
{
    int min = h[0];
    h[0] = h.back();
    h.pop_back();

    int size = h.size();
    int last = 0;
        
    int lowest = get_lowest_child(h, last);
    while (last < size && lowest != last && h[last] > h[lowest]) {
        swap(h[last], h[lowest]);
        last = lowest;
        lowest = get_lowest_child(h, last);
    }
    return min;
}

int main(int argc, char** argv)
{
    srand(time(NULL));
    
    int nums[N];
    for (int i = 0; i < N; i++) {
        nums[i] = rand() % N;
    }

    vector<int> heap(nums, nums+N);
    vector<int> to_sort(nums, nums+N);
    vector<int> heap2(nums, nums+N);

    /* my D heap */
    auto t11 = high_resolution_clock::now();
    // make heap
    for (int i = 0; i < N; i++) {
        insert(heap, i);
    }
    // sort heap
    for (int i = 0; i < N; i++) {
        delete_min(heap);
    }
    auto t12 = high_resolution_clock::now();

    /* standard sort */
    auto t21 = high_resolution_clock::now();
    sort(to_sort.begin(), to_sort.end());
    auto t22 = high_resolution_clock::now();
    
    /* make_heap + sort_heap */
    auto t31 = high_resolution_clock::now();
    make_heap(heap2.begin(), heap2.end());
    sort_heap(heap2.begin(), heap2.end());
    auto t32 = high_resolution_clock::now();

    auto dur1 = duration_cast<microseconds>(t12 - t11).count();
    auto dur2 = duration_cast<microseconds>(t22 - t21).count();
    auto dur3 = duration_cast<microseconds>(t32 - t31).count();

    cout << "My Dheap : " << dur1 << endl;
    cout << "Sort     : " << dur2 << endl;
    cout << "Make,sort: " << dur3 << endl;

    return 0;
}
