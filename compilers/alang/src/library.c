#include <stdio.h>

int citajcislo()
{
    int r;
    scanf("%d", &r);
    return r;
}

char citajznak()
{
    char c;
    scanf("%c", &c);
    return c;
}

void vypiscislo(int i)
{
    printf("%d", i);
}

void vypiscisloln(int i)
{
    printf("%d\n", i);
}

void vypisznak(char c)
{
    printf("%c", c);
}

void vypisznakln(char c)
{
    printf("%c\n", c);
}

void __writestring(char *a)
{
    printf("%s", a);
}
