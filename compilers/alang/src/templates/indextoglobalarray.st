indextoglobalarray(loadregister, type, ptrregister, exprreg) ::= <<
<ptrregister> = getelementptr inbounds <type>, <type>* <loadregister>, i32 0, i32 <exprreg>
>>
