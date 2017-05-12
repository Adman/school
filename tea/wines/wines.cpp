#include <iostream>

using namespace std;

int *prices;

int sell(int year, int left, int right, int **memory)
{
    if (right < left)
        return 0;

    if (memory[left][right] > 0)
        return memory[left][right];

    int left_p = (year * prices[left]) + sell(year+1, left+1, right, memory);
    int right_p = (year * prices[right]) + sell(year+1, left, right-1, memory);

    int max_price = left_p >= right_p ? left_p : right_p;
    memory[left][right] = max_price;
    return max_price;
}


int main()
{
    int bottles;
    cin >> bottles;

    prices = new int[bottles];
    int **memory = new int*[bottles];
    for (int i = 0; i < bottles; i++) {
        cin >> prices[i];
        memory[i] = new int[bottles];

        for (int j = 0; j < bottles; j++)
            memory[i][j] = 0;
    }

    cout << sell(1, 0, bottles-1, memory) << endl;

    return 0;
}
