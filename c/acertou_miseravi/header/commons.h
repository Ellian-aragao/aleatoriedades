#ifndef COMMON_H
#define COMMON_H

#include <stdlib.h>

typedef struct SizeStrings
{
  int operator1;
  int operator2;
} SizeStrings;

SizeStrings extract_values(const char *operador1, const char *operador2, int iteration_operator1, int iteration_operator2);

#endif