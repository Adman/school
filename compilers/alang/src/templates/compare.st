compare(opreg, op, leftexp, rightexp, register) ::= <<
<opreg> = icmp <op> i32 <leftexp>, <rightexp>
<register> = zext i1 <opreg> to i32
>>
