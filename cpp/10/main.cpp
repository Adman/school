/* 
 * File:   main.cpp
 * Author: adman
 *
 * Created on December 2, 2015, 4:11 PM
 */

#include <cstdio>
#include <cassert>
#include <cctype>

/* maximálna dĺžka výrazu plus rezerva na koniec riadku a 0 */
const int maxN = 1005;

/* vrchol aritmetickeho stromu */
struct node {
    double val;     /* ciselna hodnota */
    char op;        /* operator '+', '-', *', '/', alebo ' ' ak ide o hodnotu */
    node * left;    /* lavy podvyraz */
    node * right;  /* pravy podvyraz */
};

/* vrcholy stromu davame do zasobnika */
typedef node * dataType;

/* struktura pre zasobnik */
struct stack {
    int top;  /* pozicia vrchného prvku zásobníka */
    dataType *items; /* pole prvkov */
};

/* inicializuje prázdny zásobník */
void init(stack &s) {
    s.top = -1;
    s.items = new dataType[maxN];
}

/* zisti, ci je zasobnik prazdny */
bool isEmpty(stack &s) {
    return s.top == -1;
}

/* prida prvok s hodnotou item na vrch zasobnika */
void push(stack &s, dataType item) {
    s.top++;
    assert(s.top < maxN);
    s.items[s.top] = item;
}

/* odoberie prvok z vrchu zásobníka a vráti jeho hodnotu */
dataType pop(stack &s) {
    assert(s.top >= 0);
    s.top--;
    return s.items[s.top + 1];
}

/* vrati prvok z vrchu zasobnika a necha ho tam */
dataType peek(stack &s) {
    assert(s.top >= 0);
    return s.items[s.top];
}

/* odalokuje pamat pre zasobnik */
void destroy(stack &s) {
    delete[] s.items;
}


/* Funkcia vytvori novy vrchol stromu s operatorom op.
 * Lavy aj pravy podstrom budu zatial NULL. */
node * createOp(char op) {
    node *v = new node;
    v->left = NULL;
    v->right = NULL;
    v->op = op;
    return v;
}

/* Funkcia vytvori novy vrchol stromu s danou hodnotou,
 * lavy a pravy podvyraz bude prazdny, op bude medzera */
node * createNum(double val) {
    node *v = new node;
    v->left = NULL;
    v->right = NULL;
    v->op = ' ';
    v->val = val;
    return v;
}

/* Pomocna funkcia pre parseInfix, ktora urci prioritu znaku op */
int precedence(char op) {
    if (op == '#' || op == '(') return 0; // specialne pripady
    if (op == '-' || op == '+') return 1;
    if (op == '*' || op == '/') return 2;
    assert(false); // sem by sme sa nemali dostat
}

/* Pomocna funkcia pre parseInfix, ktora zo zasobnika operatorStack
 * vyhadzuje kým ich priorita je >= minPrecedence. Kazdym vyhodenym
 * operatorom spoji dva podstromy zo zasobnika treeStacka vysledok
 * vlozi spat do treeStack. */
void processHighPriority(stack &operatorStack,
                         stack &treeStack,
                         int minPrecedence) {
    while (precedence(peek(operatorStack)->op) >= minPrecedence) {
        node *v = pop(operatorStack);
        v->right = pop(treeStack);
        v->left = pop(treeStack);
        push(treeStack, v);
    }
}

/* Funkcia z retazca str od pozicie i precita cislo az po prvy
 * iny znak (medzera, koniec retazca, operator).
 * Index i sa nastavi na posledny znak precitaneho cisla. */
double evaluateNumber(char str[], int &i) {
    // spracovanie unarneho znamienka minus
    int sign = 1;
    while (str[i] == '-') {
        sign *= -1;
        i++;
    }

    // spracovanie celej casti cisla
    double val = 0;
    bool wasDigit = false;
    while (isdigit(str[i])) {
        val = val * 10 + (str[i] - '0');
        i++;
        wasDigit = true;
    }
    // desatinna cast cisla
    if (str[i] == '.') {
        i++;
        double power = 0.1;
        while (isdigit(str[i])) {
            val += (str[i] - '0') * power;
            power /= 10;
            i++;
            wasDigit = true;
        }
    }
    assert(wasDigit);  // kontrola, ze cislo ma aspon jednu cifru
    i--;
    return val * sign;
}

/* Funkcia z retazca infix precita vyraz v infixovom formate 
 * a vrati koren stromu reprezentujuceho tento vyraz */
node * parseInfix(char *infix) {
    stack operatorStack; // vytvor prazdny zasobnik operatorov
    init(operatorStack);
    push(operatorStack, createOp('#')); // specialne dno zasobnika

    stack treeStack;  // vytvor prazdny zasobnik stromov
    init(treeStack);

    bool wantValue = true; // ci ma nasledovat hodnota alebo operator
    for (int i = 0; infix[i] != 0; i++) {
        if (isspace(infix[i])) { /* biele znaky preskakujeme */
        } else if (infix[i] == '(') { /* zaciatok zatvorky dame na zasobnik */
            assert(wantValue);
            push(operatorStack, createOp(infix[i]));
        } else if (isdigit(infix[i]) || infix[i] == '.'
                   || (infix[i] == '-' && wantValue)) {
            // na vstupe nasleduje cislo, potencialne s unarnym minus
            assert(wantValue);
            double value = evaluateNumber(infix, i);
            wantValue = false;
            // nacitane cislo ulozime ako strom na zasobnik
            push(treeStack, createNum(value));
        } else if (infix[i] == ')') {
            /* koniec zatvorky znamena, ze vypiseme vsetky operatory,
             * co boli v tej zatvorke (a este nie su vypisane)*/
            assert(!wantValue);
            processHighPriority(operatorStack, treeStack, precedence('(') + 1);
            assert(peek(operatorStack)->op == '(');
            // zmazeme aj pomocnu uzol pre (
            node *v = pop(operatorStack);
            delete v;
        } else {
            // spravovanie operatora
            assert(infix[i] == '+' || infix[i] == '-'
                   || infix[i] == '*' || infix[i] == '/');
            assert(!wantValue);
            // zo zasobnika spracujeme vsetky operatory s vyssou
            // alebo rovnakou prioritou
            processHighPriority(operatorStack, treeStack, precedence(infix[i]));
            push(operatorStack, createOp(infix[i]));
            wantValue = true;
        }
    }

    assert(!wantValue);
    /* vsetko, co na zasobniku ostalo, spracujeme */
    processHighPriority(operatorStack, treeStack, precedence('#') + 1);
    // kontrola a zmazanie spodneho operatora #
    assert(peek(operatorStack)->op == '#');
    delete pop(operatorStack);
    assert(isEmpty(operatorStack));

    // v zasobniku stromov by mal byt iba vysledny strom
    node *root = pop(treeStack);
    assert(isEmpty(treeStack));

    // uvolnenie pamate zasobnikov
    destroy(treeStack);
    destroy(operatorStack);

    return root;
}


/* Rekurzivna funkcia, ktora vypise vyraz v infixovej notacii
 * bez nadbytocnych zatvoriek. */
void printInfix(node *v) {
    // trivialny priapd je vypisanie listu stromu
    if (v->op == ' ') {
        printf("%.4g", v->val);
    }
    else {
        // zistime, ci treba vypisovat okolo laveho dietata zatvorky
        bool printPar =
            v->left->op != ' ' && precedence(v->left->op) < precedence(v->op);
        if (printPar) {
            printf("(");
        }
        printInfix(v->left);  // lave dieta rekurzivne
        if (printPar) {
            printf(")");
        }

        printf("%c", v->op);   // vypis operatora

        // zistime, ci treba vypisovat okolo praveho dietata zatvorky
        printPar =
            v->right->op != ' ' && precedence(v->right->op) <= precedence(v->op);
        if (printPar) {
            printf("(");
        }

        printInfix(v->right); // prave dieta rekurzivne

        if (printPar) {
            printf(")");
        }
    }
}

/* Pomocna funkcia, ktora vypise zadanu spravu a na dalsi
 * riadok odsadeny o dve medzwery zadany vyraz. */
void printInfix(const char *message, node *v) {
    printf("%s\n  ", message);
    printInfix(v);
    printf("\n");
}


/* Funkcia vyhodnoti zadany aritmeticky vyraz. */
double evaluate(node *v) {
    /* vyhodnoti vyraz dany stromom s korenom vo vrchole v */
    assert(v != NULL);

    /* ak je operator medzera, vratime jednoducho hodnotu */
    if (v->op == ' ') {
        return v->val;
    }

    /* rekurzivne vyhodnotime lavy a pravy podvyraz */
    double valLeft = evaluate(v->left);
    double valRight = evaluate(v->right);

    /* Hodnotu laveho a praveho podvyrazu spojime podla typu operatora
     * a vratime. Prikaz break netreba, pouzivame return. */
    switch (v->op) {
    case '+':
        return valLeft + valRight;
    case '-':
        return valLeft - valRight;
    case '*':
        return valLeft * valRight;
    case '/':
        return valLeft / valRight;
    default:
        assert(false);
    }
}

/* Funkcia uvolni pamat zadaneho aritmetickeho vyrazu */
void destroyTree(node* v) {
    if (v != NULL) {
        destroyTree(v->left);
        destroyTree(v->right);
        delete v;
    }
}

/* Funkcia vytvori zjednodusenu kopiu zadaneho vyrazu,
 * v ktorej je kazdy lavy podstrom nahradeny konstantou. */
node *simplifiedCopy(node *v)
{
    if (v->op == ' ')
        return createNum(v->val);
    
    node *root = createOp(v->op);

    /* There will always be left side to be evaluated */
    root->left = createNum(evaluate(v->left));

    if (v->right->op != ' ')
        root->right = simplifiedCopy(v->right);
    else
        root->right = createNum(v->right->val);
    return root;
}

/* Call subtrees recursively. Also pass minus argument to know
 * whether we have to multiply something by -1 */
void minus_helper(node *root, bool minus)
{
    if (root->op == ' ') {
        root->val *= minus ? -1 : 1;
        return;
    }

    switch (root->op) {
        case '*':
        case '/':
            minus_helper(root->left, minus);
            minus_helper(root->right, false);
            break;
        case '+':
            minus_helper(root->left, minus);
            minus_helper(root->right, minus);
            break;
        case '-':
            minus_helper(root->left, minus);
            minus_helper(root->right, !minus);
            break;
    }
    if (root->op == '-')
        root->op = '+';
}

/* Funkcia vo vyraze zmeni znamienka - na + a, pricom nasobenie -1
   presunie az na listy podvyrazov tak, aby vysledny vyraz
   reprezentoval tu istu hodnotu. */
void removeMinus(node *v)
{
    if (v != NULL && v->op != ' ')
        minus_helper(v, false);
}


int main(void) {
    // nacitame a vypiseme vstupny vyraz
    char str[maxN];
    fgets(str, maxN, stdin);
    node *expr1 = parseInfix(str);
    printInfix("Input:", expr1);

    // vystvorime zjdnodusenu kopiu vyrazu expr1
    node *expr2 = simplifiedCopy(expr1);
    printInfix("Simplified copy:", expr2);

    // odstranime znamienka - v expr1
    removeMinus(expr1);
    printInfix("Remove minus in input:", expr1);

    // odstranime znamienka - v expr2
    removeMinus(expr2);
    printInfix("Remove minus in simplified:", expr2);

    // uvolnime pamat
    destroyTree(expr1);
    destroyTree(expr2);
}

