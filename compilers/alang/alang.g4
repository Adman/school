grammar alang;

init: statements;

statements: NEWLINE* statement (NEWLINE+ statement)* NEWLINE*;

statement:
    function
    | var_declaration
    | assignment
    ;

block:
    var_declaration     # BlockVarDec
    | assignment        # BlockAsgn
    | if_block          # BlockIf
    | loop_block        # BlockLoop
    | func_call         # BlockFuncCall
    | input_int         # BlockInputInt
    | input_row         # BlockInputRow
    | output_var        # BlockOutputVar
    | output_row        # BlockOutputRow
    | vypluj            # BlockReturn
    ;

function: FUNKCIA return_type ID LPAR (argtype ID (COMMA argtype ID)*)? RPAR NEWLINE+ (block NEWLINE+)* HOTOVO;

vypluj: VYPLUJ expression?;

var_declaration: BUD var_type ID (index_to_array)*;

assignment: ID (index_to_array)* ASSIGN expression;

if_block: IF LPAR condition RPAR NEWLINE+ (block NEWLINE+)+ (ELSE NEWLINE+ (block NEWLINE+)*)? NEWLINE* FI;

loop_block: MAKAJ LPAR condition RPAR NEWLINE+ (block NEWLINE+)+ NEWLINE* JAKAM;

func_call: ID LPAR (expression (COMMA expression)*)? RPAR;

input_int: CITAJCISLO ID (index_to_array*);

input_row: CITAJRIADOK ID (index_to_array)*;

output_var: VYPIS expression;

output_row: VYPISRIADOK expression;

index_to_array: LSQUARE expression RSQUARE;

var_type:
    CISLO
    | ZNAKY 
    | BOOL
    ;

return_type:
    CISLO
    | ZNAKY
    | BOOL
    | VOID;

condition:
    op=NOT condition                                                # CondNot
    | condition op=AND condition                                    # CondAnd
    | condition op=OR condition                                     # CondOr
    | LPAR condition RPAR                                           # CondPar
    | expression op=(EQ | LT | GT | LEQ | GEQ | NEQ) expression     # CondComp
    ;

expression:
    op=(ADD | SUB) expression                       # ExpUna
    | expression op=(DIV | MUL) expression          # ExpDivMul
    | expression op=(ADD | SUB) expression          # ExpAddSub
    | LPAR expression RPAR                          # ExpPar
    | ID index_to_array+                            # ExpIdArray
    | ID                                            # ExpId
    | func_call                                     # ExpFuncCall
    | INT                                           # ExpInt
    | STRING                                        # ExpString
    | TRUE                                          # ExpTrue
    | FALSE                                         # ExpFalse
    ;

argtype:
    CISLO (LSQUARE RSQUARE)*
    | ZNAKY (LSQUARE RSQUARE)*
    | BOOL (LSQUARE RSQUARE)*
    ;

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
ZNAKY: 'ZNAKY';
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
STRING: '"' ~('\r'|'\n'|'"')* '"';

NEWLINE: ('\r\n' | '\n' | '\r');
LPAR: '(';
RPAR: ')';
LSQUARE: '[';
RSQUARE: ']';
COMMA: ',';
ID: [a-zA-Z_][a-zA-Z0-9_]*;
LINE_COMMENT: '#' ~[\r\n]* -> skip;
WHITESPACE: [ \t] -> skip;
