import numpy as np
import matplotlib.pyplot as plt
from scipy import stats


y = np.loadtxt('data.txt')
x = np.arange(1, len(y)+1)


def autocor(y):
    N = len(y)
    mean = np.mean(y)
    hs = []
    for h in range(N):
        ch = np.sum((y[:N-h] - mean) * (y[h:] - mean))
        c0 = np.sum((y - mean)**2)
        hs.append(ch / c0)

    return np.array(hs)


def AR(order, y):
    a = []
    for i in range(order, len(y)):
        a.append(y[i-order:i])

    a = np.column_stack((np.ones(len(a)), np.array(a)))
    solution = np.linalg.lstsq(a, y[order:])[0]

    # first values
    ys = np.zeros(len(y))
    for i in range(order):
        ys[i] = np.sum(solution[:i+1] * np.append([1], y[:i]))
    ys[order:] = np.sum(a * solution, axis=1)
    return ys, solution


slope, intercept, _, _, _ = stats.linregress(x, y)

new_y = y - (intercept + slope*x)

Rh = autocor(new_y)

sa = np.fft.fft(Rh)
sa_mult = sa * np.conjugate(sa)

ORDER = 3
ys, ar_coefs = AR(ORDER, new_y)

predict_x = np.arange(101, 201)
predict_y = new_y
for i in range(100):
    result = np.sum(np.concatenate(([1], predict_y[100-ORDER+i:])) * ar_coefs)
    predict_y = np.append(predict_y, [result])


#plt.plot(x, y)
#plt.plot(predict_x, predict_y[100:] + (intercept + slope*predict_x))
#plt.plot(x, intercept + slope*x, color='red')
#plt.scatter(x, new_y)
#plt.plot(x, Rh)
#plt.plot(x, sa_mult)
#plt.plot(x, ys)
#plt.show()
