from collections import defaultdict


time, wants = 0, 0
amount = [0, 0, 0]
counter = 0
passed_counts = defaultdict(int)
passed = defaultdict(lambda: 0.5)


def print_probabilities(title, vals):
    print('{} = < {} >'.format(title, ', '.join(map(str, vals))))


def getp(prob, boolean):
    return prob if boolean else 1-prob


def get_probs(t, w, l, p):
    probs = []
    if t is None:
        probs.append(getp(time, True) * getp(wants, w) * amount[l] * getp(passed[(True, w, l)], p))
        probs.append(getp(time, False) * getp(wants, w) * amount[l] * getp(passed[(False, w, l)], p))

    elif w is None:
        probs.append(getp(time, t) * getp(wants, True) * amount[l] * getp(passed[(t, True, l)], p))
        probs.append(getp(time, t) * getp(wants, False) * amount[l] * getp(passed[(t, False, l)], p))

    elif l is None:
        probs.append(getp(time, t) * getp(wants, w) * amount[0] * getp(passed[(t, w, 0)], p))
        probs.append(getp(time, t) * getp(wants, w) * amount[1] * getp(passed[(t, w, 1)], p))
        probs.append(getp(time, t) * getp(wants, w) * amount[2] * getp(passed[(t, w, 2)], p))

    elif p is None:
        probs.append(getp(time, t) * getp(wants, w) * amount[l] * passed[(t, w, l)])
        probs.append(getp(time, t) * getp(wants, w) * amount[l] * (1-passed[(t, w, l)]))

    probs = [prob if prob > 0.0 else 1e-100 for prob in probs]
    alpha = 1/sum(probs)

    return list(map(lambda x: x*alpha if x*alpha > 1e-50 else 0.0, probs))


with open('naiveClassifierData.txt', 'r') as f:
    for line in f:
        if line.startswith('#'):
            continue

        t, w, l, p = map(int, line.split(' '))
        time += t
        wants += w
        amount[l] += 1
        passed_counts[(t, w, l, p)] += 1
        counter += 1


time /= counter
wants /= counter
amount = [i/counter for i in amount]
for key, value in list(passed_counts.items()):
    t, w, l, p = key
    if passed_counts[(t, w, l, True)] == 0:
        passed_counts[(t, w, l, True)] = 1e-100

    if passed_counts[(t, w, l, False)] == 0:
        passed_counts[(t, w, l, False)] = 1e-100

    passed[(t, w, l)] = passed_counts[(t, w, l, True)] / \
        (passed_counts[(t, w, l, True)] + passed_counts[(t, w, l, False)])


print_probabilities('P(p | t, w, enough)', get_probs(True, True, 1, None))
print_probabilities('P(p | not t, w, little)', get_probs(False, True, 0, None))
print_probabilities('P(t | not w, little, p)', get_probs(None, False, 0, True))
print_probabilities('P(w | t, lot, not p)', get_probs(True, None, 2, False))
print_probabilities('P(amount | t, not w, p)', get_probs(True, False, None, True))
