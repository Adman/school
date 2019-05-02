import numpy as np
import matplotlib.pyplot as plt


def get_error(y0, mi, y):
    prev = y0
    err = 0
    for i in range(len(y)):
        prev = mi * prev * (1 - prev)
        err += (y[i] - prev)**2
    return err


y = np.loadtxt('data.txt')
x = np.arange(1, len(y)+1)

updates = ((0.001, 0), (-0.001, 0), (0, 0.001), (0, -0.001))


best_err = -1
best_y0, best_mi = 0, 0
for _ in range(30):
    mi = np.random.randint(2800, 3600) / 1000
    y0 = np.random.uniform(0, 1000) / 1000

    local_best = get_error(y0, mi, y)

    changed = False
    while not changed:
        changed = False
        for upd in updates:
            err = get_error(y0 + upd[0], mi + upd[1], y)

            if err < local_best:
                changed = True
                local_best = err
                new_y0 = y0 + upd[0]
                new_mi = mi + upd[1]

        if changed:
            y0 = new_y0
            mi = new_mi

    if local_best < best_err or best_err == -1:
        best_err = local_best
        best_y0, best_mi = y0, mi

print('Y0: {}, mi: {}, err: {}'.format(best_y0, best_mi, best_err))

new_y = [best_y0]
for _ in range(len(y)):
    new_y.append(best_mi * new_y[-1] * (1 - new_y[-1]))

plt.plot(x, y, label='Original')
plt.plot(x, new_y[1:], label='Computed')
plt.plot(x, y - new_y[1:], label='Noise')
plt.legend()
plt.show()
