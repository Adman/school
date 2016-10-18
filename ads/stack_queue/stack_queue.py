def is_ice_creamy(chars):
    stack = []
    for x in chars:
        if x.islower():
            stack.append(x)
            continue

        if len(stack) == 0:
            return False

        if stack[-1] != x.lower():
            return False

        stack.pop()

    return True


def is_lunchy(chars):
    queue = []
    for x in chars:
        if x.islower():
            if x in queue:
                return False
            queue.append(x)
            continue

        if len(queue) == 0:
            return False

        if queue[0] != x.lower():
            return False

        queue.pop(0)

    return True

for i in range(int(input())):
    inp = input()
    ice = is_ice_creamy(inp)
    lunch = is_lunchy(inp)

    if ice and lunch:
        print('obojaka')
    elif (ice) and (not lunch):
        print("zmrzlinova")
    elif (not ice) and (lunch):
        print("obedova")
    else:
        print("ziadna")
