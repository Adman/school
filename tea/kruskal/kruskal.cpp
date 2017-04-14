#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct route {
    int from;
    int to;
    int dist;

    bool operator<(const route& other) const {
        return dist < other.dist;
    }
};

int main()
{
    int cities;
    vector<route> routes;
    int trash;
    int dist;

    cin >> cities;

    int *set = new int[cities];

    for (int i = 0; i < cities; i++) {
        set[i] = i;
        for (int tr = 0; tr <= i; tr++)
            cin >> trash;

        for (int j = i + 1; j < cities; j++) {
            cin >> dist;
            route r = {i, j, dist};
            routes.push_back(r);
        }
    }

    sort(routes.begin(), routes.end());

    long long distance = 0;
    for (int i = 0; i < (int) routes.size(); i++) {
        route r = routes[i];
        if (set[r.from] != set[r.to]) {
            distance += r.dist;
            int to_merge = set[r.to];
            for (int j = 0; j < cities; j++) {
                if (set[j] == to_merge)
                    set[j] = set[r.from];
            }
        } else if (r.dist < 0)
            distance += r.dist;
    }

    cout << distance << endl;

    delete[] set;

    return 0;
}
