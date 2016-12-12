a, b = input(), input()
memory = [[None] * (len(b)+1) for _ in range(len(a)+1)]


def distance(x, y):
    if memory[len(x)][len(y)] is not None:
        return memory[len(x)][len(y)]

    if len(x) == 0:
        return len(y)*11
    if len(y) == 0:
        return len(x)*10

    if x[-1] == y[-1]:
        answer = distance(x[:-1], y[:-1])
    else:
        answer = min(10 + distance(x[:-1], y),
                     11 + distance(x, y[:-1]),
                     15 + distance(x[:-1], y[:-1]))
    memory[len(x)][len(y)] = answer
    return answer

print(distance(a, b))
