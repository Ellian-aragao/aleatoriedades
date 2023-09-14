#include "../header/commons.h"

SizeStrings extract_values_from_operators_iteration(const char *operador1, const char *operador2, int iteration_operator1, int iteration_operator2)
{
  char operador1_slice[2], operador2_slice[2];

  operador1_slice[0] = operador1[iteration_operator1];
  operador2_slice[0] = operador2[iteration_operator2];
  operador1_slice[1] = '\0';
  operador2_slice[1] = '\0';

  int valor1 = atoi(operador1_slice);
  int valor2 = atoi(operador2_slice);
  return (SizeStrings){valor1,
                       valor2};
}