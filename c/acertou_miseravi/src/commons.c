#include "../header/commons.h"

int extract_value_from_operator_iteration(const char *operador, int iteration_operator)
{
  char operador_slice[2];

  operador_slice[0] = operador[iteration_operator - 1];
  operador_slice[1] = '\0';

  return atoi(operador_slice);
}

SizeStrings extract_values_from_operators_iteration(const char *operador1, const char *operador2, int iteration_operator1, int iteration_operator2)
{
  int valor1 = extract_value_from_operator_iteration(operador1, iteration_operator1);
  int valor2 = extract_value_from_operator_iteration(operador2, iteration_operator2);
  return (SizeStrings){valor1,
                       valor2};
}