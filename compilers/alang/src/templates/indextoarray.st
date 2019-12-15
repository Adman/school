indextoarray(loadregister, type, loadpointers, prevloadregister, ptrregister, ptrpointers, exprreg) ::= <<
<loadregister> = load <type><loadpointers>, <type><loadpointers>* <prevloadregister>
<ptrregister> = getelementptr inbounds <type><ptrpointers>, <type><ptrpointers>* <loadregister>, <type> <exprreg>
>>
