#include "../header/operations.h"

typedef enum Operations
{
  SOMA = 1,
  SUBTRACAO = 2,
  MULTIPLICACAO = 3,
} Operations;
Operations which_operation_type(int operation);

Operations which_operation_type(int operation)
{
  switch (operation)
  {
  case SOMA:
    return SOMA;
  case SUBTRACAO:
    return SUBTRACAO;
  case MULTIPLICACAO:
    return MULTIPLICACAO;
  default:
    perror("operation not suported, choose 1 to sum, 2 to sub and 3 to mult");
    exit(EXIT_FAILURE);
  }
}

void execute_operation_from_type_operation(char *buffer_response, const char *operador1, const char *operador2, int tipo_operacao)
{
  Operations operation = which_operation_type(tipo_operacao);
  switch (operation)
  {
  case SOMA:
    executa_operacao_soma(buffer_response, operador1, operador2);
    break;
  case SUBTRACAO:
    executa_operacao_subtracao(buffer_response, operador1, operador2);
    break;
  case MULTIPLICACAO:
    executa_operacao_multiplicacao(buffer_response, operador1, operador2);
    break;
  default:
    perror("Erro ao executar operações");
    exit(EXIT_FAILURE);
  }
}
