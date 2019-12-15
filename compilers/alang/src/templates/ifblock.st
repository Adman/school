ifblock(cmpreg, condreg, labeltrue, labelfalse, truecode, falsecode, labelend, reg) ::= <<
<cmpreg> = icmp ne i32 <condreg>, 0
br i1 <cmpreg>, label %<labeltrue>, label %<labelfalse>
<labeltrue>:
<truecode>
br label %<labelend>
<labelfalse>:
<falsecode>
br label %<labelend>
<labelend>:
<reg> = add i32 0, 0
>>
