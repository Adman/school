import random

for i in range(100000):
    for j in range(random.randint(32, 126)):
        print(chr(random.randint(48, 90)), sep='', end='')
    print()
