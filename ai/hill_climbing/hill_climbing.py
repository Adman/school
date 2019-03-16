import random

moves = ((0, -1), (0, 1), (-1, 0), (1, 0))  # ('U', 'D', 'L', 'R')


def get_pos_score(pos, world):
    return world[pos[1]][pos[0]]


def fitness(sX, sY, vector, world):
    pos = [sX, sY]
    visited = []
    score = get_pos_score(pos, world)
    for p in vector:
        pos[0] += p[0]
        pos[1] += p[1]

        if pos[0] > 9:
            pos[0] = 0
        elif pos[0] < 0:
            pos[0] = 9

        if pos[1] > 9:
            pos[1] = 0
        elif pos[1] < 0:
            pos[1] = 9

        if pos not in visited:
            score += get_pos_score(pos, world)
            visited.append(pos.copy())

    return score


def get_random_move(m):
    return m[random.randint(0, 3)]


starts = input().split(' ')
sX, sY = int(starts[0]), int(starts[1])
golds = int(input())
world = [[0 for _ in range(10)] for _ in range(10)]

for _ in range(golds):
    x = input().split(' ')
    world[int(x[1])][int(x[0])] = 1


best_score = -1
best_vec = None
for _ in range(20):
    local_best_vec = []
    for _ in range(20):
        local_best_vec.append(get_random_move(moves))

    fitness_score = fitness(sX, sY, local_best_vec, world)
    changed = True
    while changed:
        changed = False
        vector = local_best_vec.copy()
        for i in range(20):
            old_move = vector[i]
            for p in range(4):
                vector[i] = moves[p]
                fit = fitness(sX, sY, vector, world)

                if fit > fitness_score:
                    fitness_score = fit
                    local_best_vec = vector.copy()
                    changed = True

            vector[i] = old_move

    if fitness_score > best_score:
        best_score = fitness_score
        best_vec = local_best_vec


print(best_score)
print('Best vector', best_vec)
