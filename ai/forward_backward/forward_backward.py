import numpy as np
import matplotlib.pyplot as plt


STATES = ('Snowfall', 'Rain', 'Moisture', 'Dry')


# Snowfall Rain Moisture Dry
TRANS = np.array([
    [0.39, 0.20, 0.30, 0.10],
    [0.10, 0.15, 0.66, 0.08],
    [0.15, 0.25, 0.25, 0.34],
    [0.05, 0.45, 0.00, 0.49]
])

# W U S
EMIS = np.array([
    [0.70, 0.25, 0.05],
    [0.15, 0.75, 0.10],
    [0.05, 0.65, 0.30],
    [0.10, 0.10, 0.80]
])


def get_obs_num(o):
    mapping = {'W': 0, 'U': 1, 'S': 2}
    return mapping[o]


def scale_alpha(vector):
    return vector / np.sum(vector)


def forward_backward(obs):
    fs = [np.array([0.25, 0.25, 0.25, 0.25])]
    bs = [np.array([0.01, 0.01, 0.01, 0.01])]
    for o, bo in zip(obs, reversed(obs)):
        Ot = np.diag(EMIS[:, get_obs_num(o)])
        fs.append(scale_alpha((Ot @ TRANS.T) @ fs[-1]))

        BOt = np.diag(EMIS[:, get_obs_num(bo)])
        bs.append(scale_alpha((TRANS @ BOt) @ bs[-1]))

    bs = np.array(list(reversed(bs[1:])))
    fs = np.array(fs[1:])
    gammas = []
    for i in range(len(fs)):
        gammas.append(
            scale_alpha(fs[i] * bs[i])
        )

    return fs, bs, np.array(gammas)


observations = (
    ('W', 'W', 'W', 'U', 'W', 'W', 'W', 'U', 'U', 'S', 'S', 'U', 'S'),
    ('S', 'S', 'S', 'U', 'U', 'S', 'S', 'S'),
    ('U', 'U', 'W', 'U', 'U', 'U', 'W', 'W', 'U', 'U', 'S', 'S', 'S', 'U')
)

for obs in observations:
    f, b, g = forward_backward(obs)

    # print the most probable sequence
    path = []
    for gamma in g:
        path.append(STATES[np.argmax(gamma)])
    print('Most probable path', path)

    # plot f
    plt.subplot(3, 1, 1)
    for i, s in enumerate(STATES):
        plt.plot(list(range(len(obs))), f[:, i], label=s)
    plt.ylabel('Forward probabilities')
    plt.legend()

    # plot b
    plt.subplot(3, 1, 2)
    for i, s in enumerate(STATES):
        plt.plot(list(range(len(obs))), b[:, i], label=s)
    plt.ylabel('Backward probabilities')
    plt.legend()

    # plot g
    plt.subplot(3, 1, 3)
    for i, s in enumerate(STATES):
        plt.plot(list(range(len(obs))), g[:, i], label=s)
    plt.ylabel('Smoothed values')
    plt.legend()

    plt.xlabel('Time')
    plt.show()
