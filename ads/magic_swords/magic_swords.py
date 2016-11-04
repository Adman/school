m, p, s = map(int, input().split())
E = [list(map(int, input().split())) for _ in range(m)]

max_p = min(m, p)
min_e = -1
best_killed = []
best_used = []


def generate(energy, killed, used, sword):
    global min_e, best_killed, best_used

    day = len(killed)

    if day + (m-sword) < max_p:
        return

    if day == max_p:
        if min_e > energy or min_e == -1:
            min_e = energy
            best_killed = killed[:]
            best_used = used[:]
    elif energy > min_e and min_e != -1 and sword < max_p:
        return
    elif sword < m:
        for i in range(p):
            if i in killed:
                continue

            killed.append(i)
            used.append(sword)
            costed = E[sword][i] + 2*day*day + day*s
            generate(energy+costed, killed, used, sword+1)
            used.pop()
            killed.pop()
            generate(energy, killed, used, sword+1)

generate(0, [], [], 0)
print(max_p)
print(min_e)
for i in range(max_p):
    print(i, best_used[i], best_killed[i])
