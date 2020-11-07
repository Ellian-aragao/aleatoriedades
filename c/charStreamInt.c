#include <stdio.h>
#include <string.h>
int main()
{
  char nome[] = "Amanda";
  char final[10] = "";
  for (int i = 0; nome[i]; i++)
  {
    printf("%c | %d\n", nome[i], nome[i]);
    char a[2];
    a[0] = nome[i] % 10 + '0';
    strcat(final, a);
  }
  printf("resultado -> %s\n", final);
  return 0;
}
