import random
from math import sqrt


# [0 - 5)
# [5 - 40)
# [40 - 50)
# [50 - 70)
# [70 - 90)
# [90 - 100)
# [100 - 110)
# [110 - 140)
# [140 - 145)


ITERATIONS = 2000000


def get_vec_length(y, z):
    return sqrt(y**2 + z**2)


cube = 150*85*85
waste = 0
for _ in range(ITERATIONS):
    x = random.uniform(0, 150)
    y = random.uniform(-42.5, 42.5)
    z = random.uniform(-42.5, 42.5)

    vec_len = get_vec_length(y, z)

    if x < 5:
        if vec_len > x + 15:
            waste += 1

    elif 5 <= x < 40 or 50 <= x < 70 or 90 <= x < 100:
        if vec_len > 20:
            waste += 1

    elif 70 <= x < 90:
        x -= 80
        if vec_len > 10*(0.5-0.005*(x**2)) + 20:
            waste += 1

    elif 40 <= x < 50:
        if vec_len > 25:
            waste += 1

    elif 100 <= x < 110:
        if vec_len > 40:
            waste += 1

    elif 110 <= x < 140:
        if vec_len > 25:
            waste += 1

    elif 140 <= x < 145:
        x -= 140
        if vec_len > -x + 25:
            waste += 1

    elif x > 144:
        waste += 1


waste_ratio = (waste/ITERATIONS)
print("Points: {}, Waste: {}, Waste percent: {}%".format(ITERATIONS,
                                                         waste,
                                                         waste_ratio*100))
print("Cube volume: {} mm^3, Waste volume: {} mm^3".format(cube,
                                                           cube*waste_ratio))
