n, z = int(input()), int(input())
tracks, tracksR = {}, {}
for _ in range(z):
    inp = input().split(' ')
    tracks[int(inp[1])] = tracks.get(int(inp[1]), []) + [[int(inp[0]), inp[2]]]
    tracksR[int(inp[0])] = tracksR.get(int(inp[0]), []) + \
        [[int(inp[1]), inp[2]]]


def count(loc, end, lines, mem, available):
    if mem[loc]:
        return mem[loc]

    if loc == end:
        answer = 1
    else:
        answer = 0
        if loc in lines:
            for track in lines[loc]:
                if track[1] in available:
                    answer += count(track[0], end, lines, mem, available)

    mem[loc] = answer
    return answer

memory = [None] * (n+1)
print(count(n, 1, tracks, memory, ['modra']))

memory = [None] * (n+1)
memory_top = [None] * (n+1)
for i in range(n, 0, -1):
    count(i, 1, tracks, memory, ['modra', 'cervena'])
    count(i, n, tracksR, memory_top, ['modra', 'cervena'])

oneblack = 0
for k, v in tracks.items():
    for item in v:
        if item[1] == 'cierna':
            top = memory[item[0]] if memory[item[0]] else 0
            bottom = memory_top[k] if memory_top[k] else 0
            oneblack += top * bottom

print(memory[n] + oneblack)

memory = [None] * (n+1)
print(count(n, 1, tracks, memory, ['modra', 'cervena', 'cierna']))
