#include<stdio.h>

int Y = 20;

double f_de_x(double x) {
  return x * x - Y;
}

double derivada_de_f_de_x(double x) {
  return 2 * x;
}

int main()
{
  double n = Y / 2;

  for (int i = 1; i < 20; i++) {
    printf("n%02d => %.12lf\n", i, n);
    n = n - (f_de_x(n) / derivada_de_f_de_x(n));
  }

  printf("n%02d => %.12lf\n", 20, n);

  return 0;
}
