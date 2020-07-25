#include <stdio.h>

long int soma(long int a, long int b)
{
    return a + b;
}

long int subtracao(long int a, long int b)
{
    return a - b;
}

void executeFunction(long (*function)(long int, long int),long a, long b)
{
    printf("%ld\n",(*function)(a,b));
}
int main()
{
    executeFunction(soma,5,5);
    executeFunction(subtracao,5,5);
    return 0;
}