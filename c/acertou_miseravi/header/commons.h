#ifndef COMMON_H
#define COMMON_H

#include <stdlib.h>

typedef struct SizeStrings
{
  int operator1;
  int operator2;
} SizeStrings;

int extract_value_from_operator_iteration(const char *operador, int iteration_operator);

SizeStrings extract_values_from_operators_iteration(const char *operador1, const char *operador2, int iteration_operator1, int iteration_operator2);

#endif