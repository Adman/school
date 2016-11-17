%lubi(Pijan, Alkohol)
%capuje(Krcma, Alkohol, Cena)
%navstivil(Id, Pijan, Krcma, Od)
%vypil(Id, Alkohol, Mnozstvo)

noloyal(P, K) :- navstivil(ID, P, K, O), vypil(ID, A, _),
                 navstivil(ID2, P, K2, O2), vypil(ID2, A, _), \+ K=K2, O < O2.
answer_a(P,K) :- navstivil(ID, P, K, _), vypil(ID, _, _), \+ noloyal(P,K).


niekedyMenejAkoMinule(P, A) :- navstivil(ID, P, _, O), vypil(ID, A, M),
                               navstivil(ID2, P, _, O2), vypil(ID2, A, M2),
                               O < O2, M > M2.
vypilPriNavsteve(ID, P, A) :- navstivil(ID, P, _, _), vypil(ID, A, _).
niekedyNevypil(P, A) :- navstivil(ID, P, K, _), capuje(K, A, _),
                        \+ vypilPriNavsteve(ID, P, A).
answer_b(P,A) :- navstivil(ID, P, _, _), vypil(ID, A, _),
                 \+ niekedyNevypil(P, A), \+ niekedyMenejAkoMinule(P, A).


viacRovnako(P, K, A) :- navstivil(ID, P, K, _), vypil(ID, A, M),
                     navstivil(ID2, P2, K, _), vypil(ID2, A, M2), \+ P=P2, M =< M2.
najviac(P, K, A) :- navstivil(ID, P, K, _), vypil(ID, A, _), \+ viacRovnako(P, K, A).
pil(P, K, A) :- navstivil(ID, P, K, _), vypil(ID, A, _).
niekdeNeniRekorder(P, A) :- lubi(P, A), capuje(K, A, _), \+ pil(P, K, A).
niekdeNeniRekorder(P, A) :- navstivil(ID, P, K, _), vypil(ID, A, _),
                            \+ najviac(P, K, A).
answer_c(P, A) :- lubi(P, A), pil(P, _, A), \+ niekdeNeniRekorder(P, A).


vypilDrahsie(P) :- navstivil(ID, P, K, _), capuje(K, A, C), vypil(ID, A, _),
                   lubi(P, A), capuje(K, _, C2), C > C2.
vypilDrahsie(P) :- lubi(P, A), navstivil(ID, P, K, O), capuje(K, A, C), vypil(ID, A, _),
                   navstivil(ID2, P, K2, O2), capuje(K2, A, C2), 
                   \+ K = K2, C > C2, O > O2.
answer_d(P) :- navstivil(_, P, _, _), \+ vypilDrahsie(P).
