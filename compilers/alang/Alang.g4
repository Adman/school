grammar Alang;

init: statements;

statements: NEWLINE* statement (NEWLINE+ statement)* NEWLINE*;

statement:
    FUNKCIA return_type ID LPAR arguments? RPAR NEWLINE+ (block NEWLINE+)* HOTOVO  # FuncStat
    | BUD var_type ID (index_to_global_array)*                                     # VarDecStat
    | ID ASSIGN global_expression                                                  # AssignmentStat
    ;

block:
    BUD var_type ID (index_to_array)*                                       # BlockVarDec
    | ID (index_to_array)* ASSIGN expression                                # BlockAsgn
    | ID LPAR (expression (COMMA expression)*)? RPAR                        # BlockFuncCall
    | VYPISZNAKY STRING                                                     # BlockOutputString
    | VYPLUJ expression?                                                    # BlockReturn
    | MAKAJ LPAR expression RPAR NEWLINE+ (block NEWLINE+)+ NEWLINE* JAKAM  # BlockLoop
    | IF LPAR expression RPAR NEWLINE+ (block NEWLINE+)+ (ELSE NEWLINE+ (else_block NEWLINE+)*)? NEWLINE* FI # BlockIf
    | STACI                                                                 # BlockBreak
    | PRESKOC                                                               # BlockContinue
    ;

else_block: block;

arguments: argtype ID (COMMA argtype ID)*;

index_to_array: LSQUARE expression RSQUARE;
index_to_global_array: LSQUARE INT RSQUARE;

global_expression: INT | TRUE | FALSE;

expression:
    op=(ADD | SUB | NOT) expression                                 # ExpUna
    | expression op=(DIV | MUL | MOD) expression                    # ExpDivMulMod
    | expression op=(ADD | SUB) expression                          # ExpAddSub
    | expression op=(EQ | LT | GT | LEQ | GEQ | NEQ) expression     # ExpComp
    | expression op=(AND | OR) expression                           # ExpAndOr
    | LPAR expression RPAR                                          # ExpPar
    | ID index_to_array+                                            # ExpIdArray
    | ID                                                            # ExpId
    | ID LPAR (expression (COMMA expression)*)? RPAR                # ExpFuncCall
    | INT                                                           # ExpInt
    | STRING                                                        # ExpChar
    | TRUE                                                          # ExpTrue
    | FALSE                                                         # ExpFalse
    ;

argtype:
    CISLO (LSQUARE RSQUARE)*
    | ZNAK (LSQUARE RSQUARE)*
    | BOOL (LSQUARE RSQUARE)*
    ;

var_type: CISLO|ZNAK|BOOL;

return_type: CISLO|ZNAK|BOOL|VOID;

BUD: 'BUD';

FUNKCIA: 'FUNKCIA';
HOTOVO: 'HOTOVO';
VYPLUJ: 'VYPLUJ';

MAKAJ: 'MAKAJ';
JAKAM: 'JAKAM';
STACI: 'STACI';
PRESKOC: 'PRESKOC';

IF: 'IF';
ELSE: 'ELSE';
FI: 'FI';

VYPISZNAKY: 'VYPISZNAKY';

CISLO: 'CISLO';
ZNAK: 'ZNAK';
BOOL: 'BOOL';
VOID: 'VOID';

EQ: '==';
LT: '<';
GT: '>';
LEQ: '<=';
GEQ: '>=';
NEQ: '!=';
NOT: 'NOT';
AND: 'AND';
OR: 'OR';
ADD: '+';
SUB: '-';
DIV: '/';
MOD: '%';
MUL: '*';
ASSIGN: '=';

TRUE: 'TRUE';
FALSE: 'FALSE';
INT: DIGIT+;
fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
fragment UNDERSCORE: '_';
STRING: '"' ~('\r'|'\n'|'"')* '"';

NEWLINE: ('\r\n' | '\n' | '\r');
LPAR: '(';
RPAR: ')';
LSQUARE: '[';
RSQUARE: ']';
COMMA: ',';
ID: (LETTER|UNDERSCORE) (LETTER|DIGIT|UNDERSCORE)*;
LINE_COMMENT: '#' ~[\r\n]* -> skip;
WHITESPACE: [ \t] -> skip;
