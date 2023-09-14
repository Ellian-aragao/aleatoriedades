#include <stdio.h>
#include "../header/operations.h"

int main()
{
  unsigned int n_entradas;
  scanf("%u", &n_entradas);

  char operador1[500], operador2[500], response[501];
  int tipo_operacao;

  scanf("%s %s %d", operador1, operador2, &tipo_operacao);

  execute_operation_from_type_operation(response, operador1, operador2, tipo_operacao);

  printf("operador 1: %s\noperador 2: %s\noperador 3: %s\n", operador1, operador2, response);

  return 0;
}
