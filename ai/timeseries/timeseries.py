import numpy as np
import matplotlib.pyplot as plt


COLORS = ('red', 'green', 'orange')
WINDOWS = (10, 30, 50)
ALPHAS = (0.2, 0.5, 0.7)
ALPH_GAMM = (0.3, 0.5, 0.7)

def SMA(data):
    plt.plot(data[:, 0], data[:, 1])
    for window, color in zip(WINDOWS, COLORS):
        y = np.zeros(len(data))
        for i in range(len(data)):
            y[i] = np.mean(data[max(0, i-window):i+1, 1])

        plt.plot(data[:, 0], data[:, 1]-y, color=color)

    plt.title('Simple moving average')
    plt.legend(('Original',) + WINDOWS)
    plt.show()


def CMA(data):
    plt.plot(data[:, 0], data[:, 1])
    for window, color in zip(WINDOWS, COLORS):
        half_window = window // 2
        y = np.zeros(len(data))
        for i in range(len(data)):
            left = data[max(0, i-half_window):i, 1]
            right = data[i:i+half_window, 1]
            y[i] = np.mean(np.append(left, right))

        plt.plot(data[:, 0], data[:, 1]-y, color=color)

    plt.title('Centered moving average')
    plt.legend(('Original',) + WINDOWS)
    plt.show()


def DMA(data):
    plt.plot(data[:, 0], data[:, 1])
    for window, color in zip(WINDOWS, COLORS):
        y = np.zeros(len(data))
        for i in range(len(data)):
            y[i] = np.mean(data[max(0, i-window):i+1, 1])

        z = np.zeros(len(data))
        for i in range(len(data)):
            z[i] = np.mean(y[max(0, i-window):i+1])

        plt.plot(data[:, 0], data[:, 1]-z, color=color)

    plt.title('Double moving average')
    plt.legend(('Original',) + WINDOWS)
    plt.show()


def LR(data):
    n = len(data)
    x = data[:, 0]
    y = data[:, 1]

    # move data so we can apply log
    amin = np.amin(y)
    moved_data = y + abs(amin) + 1

    data2 = np.log(moved_data)

    sum_x_y = np.sum(x * data2)
    sum_x_sum_y = np.sum(x) * np.sum(data2)
    sum_xx = np.sum(x**2)
    sum_xx2 = np.sum(x)**2
    a = (n*sum_x_y - sum_x_sum_y) / (n*sum_xx - sum_xx2)

    b = np.mean(data2) - a*np.mean(x)

    A = a
    B = np.exp(b)

    plt.plot(x, y)
    plt.plot(x, B*(np.exp(x*A)) - abs(amin) - 1)
    plt.plot(x, y - B*(np.exp(x*A)) - abs(amin) - 1)

    plt.title('Linear Regression')
    plt.legend(('Original', 'Fit', 'Subtracted'))
    plt.show()


def SES(data):
    plt.plot(data[:, 0], data[:, 1])

    y = data[:, 1]
    xs = np.arange(501, 551)

    for alpha, color in zip(ALPHAS, COLORS):
        preds = np.zeros(550)
        preds[0] = y[0]
        for i in range(1, 550):
            if i <= 500:
                preds[i] = alpha*y[i-1] + (1-alpha)*preds[i-1]
            else:
                preds[i] = alpha*y[-1] + (1-alpha)*preds[i-1]

        plt.plot(xs, preds[500:], color=color)

    plt.title('Single exponential smoothing')
    plt.legend(('Original',) + ALPHAS)
    plt.show()


def DES(data):
    plt.plot(data[:, 0], data[:, 1])

    y = data[:, 1]
    xs = np.arange(501, 551)

    for alphgamm, color in zip(ALPH_GAMM, COLORS):
        preds = np.zeros(550)
        preds[0] = y[0]
        b = y[0] - y[1]
        for i in range(1, 550):
            if i < 500:
                preds[i] = alphgamm*y[i] + (1-alphgamm)*(preds[i-1] + b)
            else:
                preds[i] = preds[i-1] + b

            b = alphgamm * (preds[i] - preds[i-1]) + (1-alphgamm)*b

        plt.plot(xs, preds[500:], color=color)

    plt.title('Double exponential smoothing')
    plt.legend(('Original',) + tuple(str(x) + " alpha = gamma" for x in ALPH_GAMM))
    plt.show()


data = np.loadtxt('data.txt')


#SMA(data)
CMA(data)
#DMA(data)
#LR(data)

#SES(data)
#DES(data)
