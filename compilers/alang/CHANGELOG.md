* change names of visit methods in grammar
* changed `block` nonterminal rules so we don't jump twice
* global variables can be declared global scope and assigned constant value --
  Note, that you cannot assign to array in global scope (assignment can be performed in main function for example)
* renamed `ZNAKY` to `ZNAK`
* `ZNAK` variable might contain only one character. If you want to work with string,
  you need `ZNAK[n]` (`ZNAK` caused problems with length specification)
* added modulo operation `a % b` which returns remainder after signed division
* I decided to use i32 for BOOL type as well
* changed reading input - instead of `CITAJCISLO x`, we will use function x = citajcislo()
  and also printing the number is done via function `vypiscislo(x)` or `vypiscisloln(x)`
