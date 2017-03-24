#include <iostream>

using namespace std;

int min(int a, int b)
{
    return (a < b ? a : b);
}

struct node {
    int free;
    int f;
    int t;
    int flag;
    bool leaf;
    node *left;
    node *right;

    node *create_node(int from, int to) {
        node *n = new node;
        n->free = free;
        n->f = from;
        n->t = to;
        n->flag = 0;
        n->leaf = false;
        return n;
    }

    void distribute() {
        if (t - f > 1) {
            left = create_node(f, (f+t)/2);
            right = create_node((f+t)/2, t);
            left->distribute();
            right->distribute();
        } else {
            leaf = true;
        }
    }

    void add_flag(int num) {
        flag += num;
    }

    void update(int from, int to, int num) {
        if (f == from && t == to)
            add_flag(num);
        else {
            if (left->t > from) {
                int left_t = left->t < to ? left->t : to;
                left->update(from, left_t, num);
            }
            if (right->f < to) {
                int right_f = right->f > from ? right->f : from;
                right->update(right_f, to, num);
            }

            free = min(left->free - left->flag, right->free - right->flag);
        }
    }

    bool reservation(int from, int to, int num) {
        if (flag) {
            free -= flag;
            if (!leaf) {
                left->add_flag(flag);
                right->add_flag(flag);
            }
            flag = 0;
        }

        if (f == from && t == to) {
            if (free >= num)
                return true;
            return false;
        }

        bool left_node = true, right_node = true;
        if (left->t > from) {
            int left_t = left->t < to ? left->t : to;
            left_node = left->reservation(from, left_t, num);
        }
        if (right->f < to) {
            int right_f = right->f > from ? right->f : from;
            right_node = right->reservation(right_f, to, num);
        }

        return (left_node && right_node);
    }
};

void destroy(node *n)
{
    if (n != NULL) {
        destroy(n->left);
        destroy(n->right);
        delete n;
    }
}

int main()
{
    int n, places, requests;
    int nearest = 1;

    cin >> n >> places >> requests;

    /* Compute the nearest power of two rounded up */
    while (nearest < n)
        nearest *= 2;

    /* Create root node and distribute all the children */
    node *segtree = new node;
    segtree->free = places;
    segtree->f = 0;
    segtree->t = nearest;
    segtree->flag = 0;
    segtree->leaf = false;
    segtree->distribute();

    int x, y, z;
    for (int i = 0; i < requests; i++) {
        cin >> x >> y >> z;
        if (segtree->reservation(y, z, x)) {
            segtree->update(y, z, x);
            cout << "prijata" << endl;
        } else 
            cout << "odmietnuta" << endl;
    }

    /* Free memory */
    destroy(segtree);

    return 0;
}
