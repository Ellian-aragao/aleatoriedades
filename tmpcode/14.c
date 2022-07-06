#include <stdio.h>

int C = 20;

int main()
{
  int x1;
  int x2;
  int x3;
  int x4;

  for (x1 = 0; x1 <= C; x1++)
  {
    for (x2 = 0; x2 <= C; x2++)
    {
      for (x3 = 0; x3 <= C; x3++)
      {
        for (x4 = 0; x4 <= C; x4++)
        {
          if ((x1 + x2 + x3 + x4) == C) {
            printf("%d + %d + %d + %d = %d\n", x1, x2, x3, x4, C);
          }
        }
      }
    }
  }

  return 0;
}
