# alang

A minimalistic programming language created as a project for Compilers class.
My name starts with `A` and that's why I decided to name it `alang`.

## Specification

### Types of variables

* `CISLO` - standard 32 bit integer (i.e. `12345` or `-5`)
* `ZNAK` - ascii character (i.e. `"x"`). If you need string, use `ZNAK[length]` with `\0` in the end.
* `BOOL` - standard boolean value (`FALSE` or `TRUE`)

#### Variable declaration and assignment

* Declare as `BUD <type> <name>`
* Assigning to variable `<name> = <value>` (if the variable has been declared yet)
* Strings may contain everything except `"` and `\"` and they end with `\00`. But you can
  only assign one character at the time.
* There is no fancy increment syntactic sugar, so you have to do it this way: `x = x + 1`

##### Arrays

* Array can be declared dynamically using `BUD <type> <name>[<length>]` statement.
* You can also create multidimensional arrays by writing square brackets next to each other
`BUD <type> <name>[<width>][<height>]`
* Indexing array - `<name>[index]` or multidimensional array `<name>[i1][i2]`

All variables and arrays are available only in block they were defined in.
*Avoid using same name for variable and function.*

### Arithmetic, Logical and String operations

* Addition `<CISLO> + <CISLO>` returns `CISLO`
* Difference `<CISLO> - <CISLO>` returns `CISLO`
* Multiplication `<CISLO> * <CISLO>` returns `CISLO`
* Division `<CISLO> / <CISLO>` returns `CISLO`
* Modulo `<CISLO> % <CISLO>` returns `CISLO`
* Logical and `<BOOL> AND <BOOL>` returns `BOOL`
* Logical or `<BOOL> OR <BOOL>` returns `BOOL`
* Negation `NOT <BOOL>` returns `BOOL`
* Comparisons
    - `<CISLO> < <CISLO>` returns `BOOL` (lower than)
    - `<CISLO> > <CISLO>` returns `BOOL` (greater than)
    - `<CISLO> <= <CISLO>` returns `BOOL` (lower than or equals)
    - `<CISLO> >= <CISLO>` returns `BOOL` (greater than or equals)
    - `<CISLO> == <CISLO>` returns `BOOL` (equals)
    - `<CISLO> != <CISLO>` returns `BOOL` (does not equal)
    - `<ZNAK> < <ZNAK>` returns `BOOL` (lower than - lexicographically)
    - `<ZNAK> > <ZNAK>` returns `BOOL` (greater than - lexicographically)
    - `<ZNAK> == <ZNAK>` returns `BOOL` (equals)
    - `<ZNAK> != <ZNAK>` returns `BOOL` (does not equal)

In terms of priority, multiplication, division and modulo are of higher priority
than addition and difference. Also, `AND` is of higher priority than `OR`.
It's better to use braces to make sure that operations will be executed
in order you expect i.e. `(a + b) * c` means that `a` is added to `b` and
the result multiplied by `c`.

### I/O

* `<variable> = citajcislo()` - read `CISLO` from stdin and save to variable
* `vypiscislo(x)` - write contents of `x` of type `CISLO` to stdout
* `vypiscisloln(x)` - the same as `vypiscislo`, but with newline character
* `<variable> = citajznak()` - read `ZNAK` from stdin and save to variable
* `vypisznak(x)` - write contents of `x` of type `ZNAK` to stdout
* `vypisznakln(x)` - write contents of `x` of type `ZNAK` to stdout

### Conditions

```
IF (<expression>)
    <statement>
ELSE
    <statement>
FI
```

where `<expression>` is connection of logicals which results in either `TRUE` or `FALSE`.
In case of `TRUE`, `<statement>` block under `IF` will be executed. Otherwise,
`<statement>` block within `ELSE` block will be executed. `ELSE` block might
be ommited, but remember that you have to always close condition block by
`FI` keyword.

### Loops

"while" loop, which loops while `<expression>` is returning `TRUE`
```
MAKAJ (<expression>)
    <statement>
JAKAM
```

Loop might be interrupted by the keyword `STACI` (`break` in other languages)
and skipped by the keyword `PRESKOC` (`continue` in other languages).

### Functions

The function type here means the return type. If the function returns nothing,
use `VOID` keyword. Note, that you cannot return array.
```
FUNKCIA <type> <name>(<type> arg1, <type> arg2, ..., <type> argn)
    <statement>
HOTOVO
```

Use `VYPLUJ` keyword to return value from the function.
`VYPLUJ x`

To call a function, use `<name>(args...)`.
Example of calling a function and assigning its return value to a variable:
`x = function(arg1, arg2, ...)`

### Comments

Comment starts with hash `#` and everything afterwards will be marked as
a comment (till the end of the line)

### Program Structure

Every program must contain a function called `MAIN` with type `CISLO`
which is being called upon starting the program by default.
There are no semicolons after each command because the compiler accepts
only one command per line. Also note that indentation does not matter.

### Examples

* [Finding maximum](examples/maximum.alang)
* [Sorting strings lexicographically](examples/stringsort.alang)
* [Shortest paths in graph](examples/shortestpaths.alang)

Example programs which should fail at compile time can be found
in [test fail directory](examples/test_fail).

## Scripts

If you want to build compiler, move to `src` directory and run `make`.

If you want to compile library, move to `src` directory and run `make library`.

To compile a program written in alang, run following

```bash
$ ./compile.sh /path/to/program.alang > path/to/output.ll
```

To run the compiled program, run following

```bash
$ ./run.sh path/to/output.ll
```
