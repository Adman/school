from random import uniform
from helpers import (
    alarm_lookup,
    jc_lookup,
    mc_lookup,
    BGPROB,
    EQPROB,
    print_probability
)


SAMPLES = 10000000


sum_p_a = 0
sum_p_b_e = 0
sum_p_m_j = 0
sum_p_nm_nj = 0
sum_p_a_b_e = 0
for _ in range(SAMPLES):
    bg = uniform(0, 1)
    eq = uniform(0, 1)
    al = uniform(0, 1)
    jc = uniform(0, 1)
    mc = uniform(0, 1)

    ALARMON = al <= alarm_lookup[(bg <= BGPROB, eq <= EQPROB)]

    sum_p_a += ALARMON
    sum_p_b_e += bg <= BGPROB and eq <= EQPROB
    sum_p_m_j += jc <= jc_lookup[ALARMON] and mc <= mc_lookup[ALARMON]
    sum_p_nm_nj += jc <= 1-jc_lookup[ALARMON] and mc <= 1-mc_lookup[ALARMON]
    sum_p_a_b_e += bg <= BGPROB and eq <= EQPROB and ALARMON


print_probability('P(a)', sum_p_a / SAMPLES)
print_probability('P(b,e)', sum_p_b_e / SAMPLES)
print_probability('P(m,j)', sum_p_m_j / SAMPLES)
print_probability('P(not m,not j)', sum_p_nm_nj / SAMPLES)
print_probability('P(a,b,e)', sum_p_a_b_e / SAMPLES)
