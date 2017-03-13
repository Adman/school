#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct item {
    int index;
    int height;
};

bool cmp(item i, item j)
{
    return i.height > j.height;
}

int main()
{
    int n, d;

    cin >> n >> d;

    vector<item> items;
    int *sets = new int[n];
    int *outs = new int[d];
    int *days = new int[d];

    int inp;
    for (int i = 0; i < n; i++) {
        cin >> inp;
        item newitem = {i, inp};
        items.push_back(newitem);
        sets[i] = inp;
    }

    for (int i = 0; i < d; i++) {
        cin >> inp;
        days[i] = inp;
    }

    sort(items.begin(), items.end(), cmp);

    int segments = 0;
    int itm = 0;

    for (int i = d-1; i >= 0; i--) {
        int h = days[i];
        if (itm >= n || h >= items[itm].height) {
            outs[i] = segments;
            continue;
        }

        while (itm < n && items[itm].height > h) {
            item x = items[itm];

            if (n > 1) {
                if (x.index == 0) {
                    /* left edge */
                    if (x.height < sets[1])
                        sets[0] = sets[1];
                    else
                        segments++;
                } else if (x.index == n-1) {
                    /* right edge */
                    if (x.height <= sets[n-2])
                        sets[n-1] = sets[n-2];
                    else
                        segments++;
                } else if (x.height <= sets[x.index-1] && x.height < sets[x.index+1]) {
                    sets[x.index] = sets[x.index-1];
                    segments--;
                } else if (x.height <= sets[x.index-1]) {
                    sets[x.index] = sets[x.index-1];
                } else if (x.height < sets[x.index+1]) {
                    sets[x.index] = sets[x.index+1];
                } else {
                    segments++;
                }
            } else {
                segments++;
            }
            itm++;
        }
        outs[i] = segments;
    }

    for (int i = 0; i < d-1; i++)
        cout << outs[i] << " ";
    cout << outs[d-1] << endl;

    delete[] sets;
    delete[] days;
    delete[] outs;

    return 0;
}
