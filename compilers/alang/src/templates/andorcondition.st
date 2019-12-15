andorcondition(reg1, reg2, leftexp, rightexp, opreg, op, register) ::= <<
<reg1> = icmp ne i32 <leftexp>, 0
<reg2> = icmp ne i32 <rightexp>, 0
<opreg> = <op> i1 <reg1>, <reg2>
<register> = zext i1 <opreg> to i32
>>
