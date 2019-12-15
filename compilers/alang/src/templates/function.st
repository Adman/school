function(returntype, name, args, allocaargs, storeargs, code, returndefault) ::= <<
define <returntype> @<name>(<args>) {
start:
<allocaargs>
<storeargs>
<code>
br label %end
end:
<returndefault>
}
>>
