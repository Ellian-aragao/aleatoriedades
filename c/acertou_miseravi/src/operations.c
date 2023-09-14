#include "../header/operations.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum Operations
{
  SOMA = 1,
  SUBTRACAO = 2,
  MULTIPLICACAO = 3,
} Operations;

typedef struct SizeStrings
{
  int operator1;
  int operator2;
} SizeStrings;

Operations which_operation_type(int operation);
SizeStrings extract_values(const char *operador1, const char *operador2, int iteration_operator1, int iteration_operator2);

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

SizeStrings extract_values(const char *operador1, const char *operador2, int iteration_operator1, int iteration_operator2)
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

void executa_operacao_soma(char *buffer_response, const char *operador1, const char *operador2)
{
  int size_operador1 = strlen(operador1);
  int size_operador2 = strlen(operador2);

  int resto = 0;
  int i, j;
  for (i = size_operador1 - 1, j = size_operador2 - 1; i >= 0; i--, j--)
  {
    SizeStrings values = extract_values(operador1, operador2, i, j);

    int soma = values.operator1 + values.operator2 + resto;

    if (soma % 10 != 0)
    {
      buffer_response[i] = soma % 10 + '0';
      resto = 0;
    }
    else
    {
      buffer_response[i] = '0';
      resto = 1;
    }
  }

  if (resto != 0)
  {
    buffer_response[i] = '1';
  }

  int buffer_last_element = size_operador1 > size_operador2 ? size_operador1 : size_operador2;

  buffer_response[buffer_last_element + 1] = '\0';
}

void executa_operacao_subtracao(char *buffer_response, const char *operador1, const char *operador2) {}
void executa_operacao_multiplicacao(char *buffer_response, const char *operador1, const char *operador2) {}