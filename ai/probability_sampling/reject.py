from random import uniform
from helpers import (
    alarm_lookup,
    jc_lookup,
    mc_lookup,
    BGPROB,
    EQPROB,
    print_probability
)


TOTAL_SAMPLES = 1000000


s_na, sum_p_j = 0, 0
s_a_nb, sum_p_j2 = 0, 0
s_a, sum_p_b = 0, 0
s_j_nm, sum_p_b2 = 0, 0
s_b_or_e, sum_p_j3 = 0, 0
for _ in range(TOTAL_SAMPLES):
    bg = uniform(0, 1)
    eq = uniform(0, 1)
    al = uniform(0, 1)
    jc = uniform(0, 1)
    mc = uniform(0, 1)

    ALARMON = al <= alarm_lookup[(bg <= BGPROB, eq <= EQPROB)]
    ALARMOFF = al <= 1-alarm_lookup[(bg <= BGPROB, eq <= EQPROB)]

    s_na += ALARMOFF
    sum_p_j += ALARMOFF and jc <= jc_lookup[False]

    s_a_nb += ALARMON and bg <= 1-BGPROB
    sum_p_j2 += ALARMON and bg <= 1-BGPROB and jc <= jc_lookup[True]

    s_a += ALARMON
    sum_p_b += ALARMON and bg <= BGPROB

    s_j_nm += jc <= jc_lookup[ALARMON] and mc <= 1-mc_lookup[ALARMON]
    sum_p_b2 += jc <= jc_lookup[ALARMON] and mc <= 1-mc_lookup[ALARMON] and bg <= BGPROB

    s_b_or_e += bg <= BGPROB or eq <= EQPROB
    sum_p_j3 += (bg <= BGPROB or eq <= EQPROB) and jc <= jc_lookup[ALARMON]


print_probability('P(j | not a)', sum_p_j / s_na)
print_probability('P(j | a, not b)', sum_p_j2 / s_a_nb)
print_probability('P(b | a)', sum_p_b / s_a)
print_probability('P(b | j, not m)', sum_p_b2 / s_j_nm)
print_probability('P(j | b or e)', sum_p_j3 / s_b_or_e)
