class Node:
    def __init__(self, val):
        self.left = None
        self.right = None
        self.val = val
        self.lchilds = 1

    def add_child(self, node):
        if node.val < self.val:
            self.lchilds += 1
            if self.left is None:
                self.left = node
            else:
                self.left.add_child(node)
        else:
            if self.right is None:
                self.right = node
            else:
                self.right.add_child(node)

    def kth_lowest(self, k):
        if self.lchilds > k + 1:
            return self.left.kth_lowest(k)
        elif self.lchilds == k + 1:
            return self.val
        return self.right.kth_lowest(k-self.lchilds)


class BinarySearchTree:
    def __init__(self):
        self.root = None

    def add_node(self, node):
        if self.root is None:
            self.root = node
        else:
            self.root.add_child(node)

    def kth_lowest(self, k):
        return self.root.kth_lowest(k)


q = int(input())
bts = BinarySearchTree()
for _ in range(q):
    inp = input().split(' ')
    op, k = inp[0], int(inp[1])

    if op == 'i':
        bts.add_node(Node(k))
    elif op == 'f':
        print(bts.kth_lowest(k))
