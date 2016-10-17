def get_parent(last):
    return (last - 2)//2 if last % 2 == 0 else (last - 1)//2


def get_greater_child(last, inp):
    left_index = (2*last) + 1
    right_index = (2*last) + 2

    if len(inp) > right_index:
        if inp[left_index] > inp[right_index]:
            return left_index
        return right_index
    return left_index


def remove_highest_and_bubble(heap):
    counter = 0
    while len(heap) > 1:
        heap[0] = heap.pop()
        last = 0

        child = get_greater_child(last, heap)
        while last < len(heap) and child < len(heap) and\
                heap[child] > heap[last]:
            heap[last], heap[child] = heap[child], heap[last]
            counter += 1
            last = child
            child = get_greater_child(last, heap)
    return counter


def algorithmA(inp):
    heap = []
    counter = 0
    # insert items into heap
    for i in inp:
        heap.append(i)
        last = len(heap) - 1

        if len(heap) > 1:
            parent = get_parent(last)
            while last != 0 and heap[parent] < heap[last]:
                heap[parent], heap[last] = heap[last], heap[parent]
                counter += 1
                last = parent
                parent = get_parent(last)

    print(counter)
    print(remove_highest_and_bubble(heap))


def algorithmB(inp):
    heap = inp
    last = len(heap) - 1
    counter = 0

    for i in range(len(heap)-1, -1, -1):
        last = i
        child = get_greater_child(last, heap)
        while last < len(heap)-1 and child < len(heap) and\
                heap[child] > heap[last]:
            heap[last], heap[child] = heap[child], heap[last]
            counter += 1
            last = child
            child = get_greater_child(last, heap)

    print(counter)
    print(remove_highest_and_bubble(heap))

n = int(input())
inp = [int(input()) for _ in range(n)]
algorithmA(inp)
algorithmB(inp)
