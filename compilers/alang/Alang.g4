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
    | CITAJCISLO ID (index_to_array*)                                       # BlockInputInt
    | CITAJRIADOK ID (index_to_array)*                                      # BlockInputRow
    | VYPIS expression                                                      # BlockOutputVar
    | VYPISRIADOK expression                                                # BlockOutputRow
    | VYPLUJ expression?                                                    # BlockReturn
    | MAKAJ LPAR condition RPAR NEWLINE+ (block NEWLINE+)+ NEWLINE* JAKAM   # BlockLoop
    | IF LPAR condition RPAR NEWLINE+ (block NEWLINE+)+ (ELSE NEWLINE+ (block NEWLINE+)*)? NEWLINE* FI # BlockIf
    ;

arguments: argtype ID (COMMA argtype ID)*;

index_to_array: LSQUARE expression RSQUARE;
index_to_global_array: LSQUARE INT RSQUARE;


condition:
    op=NOT condition                                                # CondNot
    | condition op=AND condition                                    # CondAnd
    | condition op=OR condition                                     # CondOr
    | LPAR condition RPAR                                           # CondPar
    | expression op=(EQ | LT | GT | LEQ | GEQ | NEQ) expression     # CondComp
    ;

global_expression: INT | STRING | TRUE | FALSE;

expression:
    op=(ADD | SUB) expression                       # ExpUna
    | expression op=(DIV | MUL) expression          # ExpDivMul
    | expression op=(ADD | SUB) expression          # ExpAddSub
    | LPAR expression RPAR                          # ExpPar
    | ID index_to_array+                            # ExpIdArray
    | ID                                            # ExpId
    | ID LPAR (expression (COMMA expression)*)? RPAR # ExpFuncCall
    | INT                                           # ExpInt
    | STRING                                        # ExpString
    | TRUE                                          # ExpTrue
    | FALSE                                         # ExpFalse
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

IF: 'IF';
ELSE: 'ELSE';
FI: 'FI';

CITAJCISLO: 'CITAJCISLO';
CITAJRIADOK: 'CITAJRIADOK';
VYPIS: 'VYPIS';
VYPISRIADOK: 'VYPISRIADOK';

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
