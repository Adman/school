import matplotlib.pyplot as plt


STATES = ('Snowfall', 'Rain', 'Moisture', 'Dry')

TRANS = {
    'Snowfall': {
        'Snowfall': 0.40, 'Rain': 0.20, 'Moisture': 0.30, 'Dry': 0.10
    },
    'Rain': {
        'Rain': 0.15, 'Snowfall': 0.10, 'Moisture': 0.67, 'Dry': 0.08
    },
    'Moisture': {
        'Moisture': 0.25, 'Rain': 0.25, 'Snowfall': 0.15, 'Dry': 0.35
    },
    'Dry': {
        'Dry': 0.50, 'Rain': 0.45, 'Moisture': 0.0, 'Snowfall': 0.05
    }
}

EMIS = {
    'Snowfall': {'W': 0.70, 'U': 0.25, 'S': 0.05},
    'Rain':     {'W': 0.15, 'U': 0.75, 'S': 0.10},
    'Moisture': {'W': 0.05, 'U': 0.65, 'S': 0.30},
    'Dry':      {'W': 0.10, 'U': 0.10, 'S': 0.80}
}


def scale_alpha(row):
    probsum = sum([x[1] for x in row])
    return [(r[0], r[1]/probsum, r[2]) for r in row]


def get_max_p(s, observed, prevs):
    probs = []
    for prev in prevs:
        p = prev[1] * TRANS[prev[0]][s] * EMIS[s][observed]
        probs.append((s, p, prev[0]))

    return max(probs, key=lambda x: x[1])


def viterbi(observs, states):
    # matrix = len(observs)*len(states)
    # columns = Snowfall Rain Moisture Dry
    matrix = []

    # initialize
    initials = []
    for s in states:
        p = 0.25 * EMIS[s][observs[0]]
        # append probability and prev
        initials.append((s, p, None))

    matrix.append(scale_alpha(initials))
    for t in range(1, len(observs)):
        row = []
        for s in states:
            row.append(get_max_p(s, observs[t], matrix[t-1]))

        matrix.append(scale_alpha(row))

    return matrix


observations = (
    ('W', 'W', 'W', 'U', 'W', 'W', 'W', 'U', 'U', 'S', 'S', 'U', 'S'),
    ('S', 'S', 'S', 'U', 'U', 'S', 'S', 'S'),
    ('U', 'U', 'W', 'U', 'U', 'U', 'W', 'W', 'U', 'U', 'S', 'S', 'S', 'U')
)

for obs in observations:
    m = viterbi(obs, STATES)
    print('Most probable path: ', end='')
    last = sorted(m[-1], key=lambda x: x[1], reverse=True)[0]
    predictions = []
    i = len(m) - 1
    while True:
        predictions.append(last[0])
        if last[2] is None:
            break

        for p in m[i-1]:
            if p[0] == last[2]:
                last = p
                break
        i -= 1
    print(list(reversed(predictions)))

    # plot graphs
    for i, s in enumerate(STATES):
        plt.plot(list(range(len(obs))),
                 [a[i][1] for a in m],
                 label=s)
    plt.legend()
    plt.show()
