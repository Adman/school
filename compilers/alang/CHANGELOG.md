* global variables can be declared in global scope and assigned constant value --
  Note, that you cannot assign to array in global scope (assignment can be performed in main function for example)
* renamed `ZNAKY` to `ZNAK`
* `ZNAK` variable might contain only one character. If you want to work with string,
  you need `ZNAK[n]` (`ZNAK` caused problems with length specification)
* added modulo operation `a % b` which returns remainder after signed division
* removed `ZNAK` + `ZNAK` and `ZNAK` + `CISLO` operations
* I decided to use i32 for BOOL type as well
* changed reading input - instead of `CITAJCISLO x`, we will use function `x = citajcislo()`
  and also printing the number is done via function `vypiscislo(x)` or `vypiscisloln(x)`
* reading character changed to `x = citajznak()` and printing one character changed
  to `vypisznak(x)` and `vypisznakln(x)`
* removed `CITAJRIADOK variable`
* removed `VYPISRIADOK x` -- writing constant string to stdout using `VYPISZNAKY "string"`
* clarified character assignment - you can assign only one character at time as well as special
  characters `\0`, `\n`, `\r`, `\b`, `\a`, `\f`, `\t`, `\v`, `\\`
* fixed example programs to work with changelog specification
