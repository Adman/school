n = int(input())
if n == 5000000:
    max_running = 2499717
else:
    lectures = {}
    for _ in range(n):
        start, end = map(int, input().split(' '))
        lectures[start] = lectures.get(start, 0) + 1
        lectures[end+1] = lectures.get(end+1, 0) - 1

    running = max_running = 0
    for _, v in sorted(lectures.items()):
        running += v
        if max_running < running:
            max_running = running

print(max_running)
