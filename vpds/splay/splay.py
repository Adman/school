import sys
import random

sys.setrecursionlimit(100000)


class AbstractNode(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None

    # we assume that the number x is already in the tree
    def find(self, x, steps):
        steps += 1
        if self.val == x:
            return self, steps

        if self.val > x:
            return self.left.find(x, steps)
        return self.right.find(x, steps)

    def insert(self, node):
        if node.val < self.val:
            if self.left is None:
                self.left = node
                self.left.parent = self
            else:
                self.left.insert(node)
        else:
            if self.right is None:
                self.right = node
                self.right.parent = self
            else:
                self.right.insert(node)

    def cik(self):
        self.parent.val, self.val = self.val, self.parent.val

        if self == self.parent.left:
            alpha = self.left
            beta = self.right
            gama = self.parent.right

            self.parent.right = self
            self.parent.left = alpha
            self.left = beta
            self.right = gama
            if alpha is not None:
                alpha.parent = self.parent
            if gama is not None:
                gama.parent = self
        else:
            alpha = self.parent.left
            beta = self.left
            gama = self.right

            self.parent.left = self
            self.parent.right = gama
            self.left = alpha
            self.right = beta
            if alpha is not None:
                alpha.parent = self
            if gama is not None:
                gama.parent = self.parent


class Node(AbstractNode):
    def __init__(self, val):
        super(Node, self).__init__(val)

    def splay(self):
        if self.parent is None:
            return

        self.cik()
        self.parent.splay()


class BNode(AbstractNode):
    def __init__(self, val):
        super(BNode, self).__init__(val)

    def splay(self):
        if self.parent is None:
            return

        # cik
        if self.parent.parent is None:
            self.cik()
            return
        # cik-cik
        elif (self == self.parent.left and self.parent == self.parent.parent.left) or \
                (self == self.parent.right and self.parent == self.parent.parent.right):
            self.parent.cik()
            self.cik()
        # cik-cak
        else:
            self.cik()
            self.parent.cik()
        self.parent.splay()


# insert elements 1, ..., N
def build_trees(nums):
    tree = None
    treeB = None

    numbers = list(range(nums))
    random.shuffle(numbers)
    for i in numbers:
        if tree is None:
            tree = Node(i)
            treeB = BNode(i)
        else:
            tree.insert(Node(i))
            treeB.insert(BNode(i))
    return tree, treeB


# test A - finds 1, ..., N three times
def test_a(n):
    t, tB = build_trees(n)
    steps, stepsB = 0, 0
    for _ in range(3):
        for i in range(n):
            node, steps = t.find(i, steps)
            node.splay()

            nodeB, stepsB = tB.find(i, stepsB)
            nodeB.splay()
    print("{0},{1},{2}".format(n, steps / (3*n), stepsB / (3*n)))


# test B - take each n/k-th item, shuffle, find 200x, then 100x and count
def test_b(n, k):
    t, tB = build_trees(n)
    steps, stepsB = 0, 0
    nk = n // k
    items = list(range(100, n, nk))
    random.shuffle(items)

    for _ in range(200):
        for i in items:
            node, _ = t.find(i, 0)
            node.splay()

            nodeB, _ = tB.find(i, 0)
            nodeB.splay()

    for _ in range(100):
        for i in items:
            node, steps = t.find(i, steps)
            node.splay()

            nodeB, stepsB = tB.find(i, stepsB)
            nodeB.splay()

    print("{0},{1},{2},{3}".format(n, k, steps / k*100, stepsB / k*100))


# test C - take item x_i = n/2, find random item in (x_i-d, x_i+d)
# and continue
def test_c(n, d):
    t, tB = build_trees(n)
    steps, stepsB = 0, 0

    item = n // 2
    node, _ = t.find(item, 0)
    node.splay()
    nodeB, _ = tB.find(item, 0)
    nodeB.splay()

    for _ in range(100):
        item = random.randint(max(item - d, 0), min(item + d, n-1))

        node, steps = t.find(item, steps)
        node.splay()

        nodeB, stepsB = tB.find(item, stepsB)
        nodeB.splay()

    print("{0},{1},{2},{3}".format(n, d, steps / 100, stepsB / 100))


# test_a(10000)
# test_b(10000, 5000)
# test_c(100000, 500)
