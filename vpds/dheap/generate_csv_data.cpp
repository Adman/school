#include <chrono>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <iostream>

using namespace std;
using namespace std::chrono;

const int D = 7;
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
    int last = index;
    int parent = get_parent(last);

    while (last > 0 && h[parent] > h[last]) {
        swap(h[parent], h[last]);
        last = parent;
        parent = get_parent(last);
    }
}

int delete_min(vector<int> &h)
{
    int min = h[0];
    h[0] = h.back();
    h.pop_back();

    int size = h.size();
    if (size > 0) {
        int last = 0;
        
        int lowest = get_lowest_child(h, last);
        while (last < size && lowest != last && h[last] > h[lowest]) {
            swap(h[last], h[lowest]);
            last = lowest;
            lowest = get_lowest_child(h, last);
        }
    }
    return min;
}

int main(int argc, char** argv)
{
    srand(time(NULL));
    vector<int> heap;
    vector<int> to_sort;
    vector<int> heap2;

    //int nums[N]
    vector<int> nums;

    vector<int> times(3);
    
    for (int steps = 100; steps <= 10000; steps += 100) {
    
    nums.clear();
    for (int i = 0; i < steps; i++) {
        //nums[i] = rand() % 1000;
        nums.push_back(rand() % steps);
    }

    times[0] = 0;
    times[1] = 0;
    times[2] = 0;

    for (int x = 0; x < 10; x++) {
    heap.clear();
    to_sort.clear();
    heap2.clear();
    
    for (int i = 0; i < N; i++) {
        heap.push_back(nums[i]);
        to_sort.push_back(nums[i]);
        heap2.push_back(nums[i]);
    }

    /* my D heap */
    auto t11 = high_resolution_clock::now();
    for (int i = 0; i < N; i++) {
        insert(heap, i);
    }
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

    times[0] += dur1;
    times[1] += dur2;
    times[2] += dur3;
    
    }
    cout << steps << "," << times[0]/10 << "," << times[1]/10 << "," << times[2]/10 << endl;
    }

    /*cout << "My Dheap : " << dur1 << endl;
    cout << "Sort     : " << dur2 << endl;
    cout << "Make,sort: " << dur3 << endl;*/

    return 0;
}
