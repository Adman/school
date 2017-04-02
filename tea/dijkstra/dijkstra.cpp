#include <iostream>
#include <vector>
#include <climits>
#include <queue>
#include <algorithm>

using namespace std;

struct edge {
    int to;
    int dist;
};

struct node {
    int id;
    int dist;

    bool operator>(const node &other) const {
        return dist > other.dist;
    }
};

int main()
{
    ios::sync_with_stdio(false);

    int verts;
    int edges;

    cin >> verts >> edges;

    /* Graph represented using adjacency lists */
    vector<vector<edge> > G(2*verts, vector<edge>(100));
    vector<int> dists(2*verts, INT_MAX);
    vector<bool> visited(2*verts, false);

    int u, v, dist;
    /* Create graph containing 2*v vertices and 2*e edges
     * The even vertices are at indexes 2*i and odd ones at 2*i + 1 */
    for (int i = 0; i < edges; i++) {
        cin >> u >> v >> dist;
        u--;
        v--;
        edge e0 = {2*v, dist};
        edge e1 = {2*v + 1, dist};
        edge e2 = {2*u, dist};
        edge e3 = {2*u + 1, dist};

        G[2*u + 1].push_back(e0);
        G[2*u].push_back(e1);
        G[2*v + 1].push_back(e2);
        G[2*v].push_back(e3);
    }

    priority_queue<node, vector<node>, greater<node> > queue;

    node start = {0, 0};
    queue.push(start);
    dists[0] = 0;

    bool found = false;
    node current;
    while (!queue.empty()) {
        current = queue.top();
        queue.pop();

        if (dists[current.id] == INT_MAX || visited[current.id])
            continue;

        visited[current.id] = true;

        if (current.id == 2*verts - 2) {
            found = true;
            break;
        }

        for (int i = 0; i < (int) G[current.id].size(); i++) {
            edge neighbour = G[current.id][i];
            if (visited[neighbour.to])
                continue;

            if (dists[neighbour.to] == INT_MAX)
                dists[neighbour.to] = dists[current.id] + neighbour.dist;
            else
                dists[neighbour.to] = min(dists[neighbour.to],
                                          dists[current.id] + neighbour.dist);


            node to_push = {neighbour.to, dists[neighbour.to]};
            queue.push(to_push);
        }
    }

    if (found)
        cout << dists[2*verts - 2] << endl;
    else
        cout << "-1" << endl;

    return 0;
}
