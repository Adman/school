# P(A | B,E)
alarm_lookup = {
    (True, True): 0.95,
    (True, False): 0.94,
    (False, True): 0.29,
    (False, False): 0.001
}

# P(JC | A)
jc_lookup = {
    True: 0.9,
    False: 0.05
}
# P(MC | A)
mc_lookup = {
    True: 0.7,
    False:  0.01
}

BGPROB = 0.001
EQPROB = 0.002


def print_probability(title, val):
    print('{} = {}'.format(title, val))
