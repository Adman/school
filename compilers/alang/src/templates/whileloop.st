whileloop(labelcmp, exprcode, cmpreg, exprreg, labeltrue, labelend, truecode, reg) ::= <<
br label %<labelcmp>
<labelcmp>:
<exprcode><cmpreg> = icmp ne i32 <exprreg>, 0
br i1 <cmpreg>, label %<labeltrue>, label %<labelend>
<labeltrue>:
<truecode>
br label %<labelcmp>
<labelend>:
<reg> = add i32 0, 0
>>
