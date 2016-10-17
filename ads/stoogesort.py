from math import ceil


def stoogesort(x, y, arr):
    """Sort recursively using stooge sort and count recursion calling."""
    global counter
    counter += 1

    n = len(arr)
    if n <= 1:
        pass
    elif n == 2:
        if arr[0] > arr[1]:
            arr[0], arr[1] = arr[1], arr[0]
    elif n > 2:
        q = ceil((n*x) / y)
        if q >= n:
            q = n-1
        arr[0:q] = stoogesort(x, y, arr[0:q])
        arr[n-q:n] = stoogesort(x, y, arr[n-q:n])
        arr[0:q] = stoogesort(x, y, arr[0:q])

    return arr


n, x, y = list(map(int, input().split()))
ascending = list(range(n))
stooge_arr = list(reversed(ascending))
counter = 0

stooge_arr = stoogesort(x, y, stooge_arr)

print(ascending == stooge_arr)
print(counter)
