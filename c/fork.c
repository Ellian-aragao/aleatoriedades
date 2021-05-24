#include <stdio.h>
#include <unistd.h>
#define N 4

int main()
{
  int pid = 0;
  for (int i = 0; i < N; i++)
  {
    if (!pid)
    {
      pid = fork();
      printf("hello world\n");
    }
  }
  return 0;
}
