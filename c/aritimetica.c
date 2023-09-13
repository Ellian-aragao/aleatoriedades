#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void executa_operacao_soma(char *buffer_response, const char *operador1, const char *operador2, int tipo_operacao)
{
  int size_operador1 = strlen(operador1);
  int size_operador2 = strlen(operador2);

  int resto = 0;
  int i;
  for (i = size_operador1 - 1; i >= 0; i--)
  {
    // buffer pro calculo
    char operador1_slice[2], operador2_slice[2];

    // operação para processamento do numero como string
    operador1_slice[0] = operador1[i];
    operador2_slice[0] = operador2[i];
    operador1_slice[1] = '\0';
    operador2_slice[1] = '\0';

    // transformação em inteiro
    int valor1 = atoi(operador1_slice);
    int valor2 = atoi(operador2_slice);

    // operação
    int soma = valor1 + valor2 + resto;

    if (soma % 10 != 0)
    {
      buffer_response[i + 1] = soma % 10 + '0';
      resto = 0;
    }
    else
    {
      buffer_response[i + 1] = '0';
      resto = 1;
    }
  }

  if (resto != 0)
  {
    buffer_response[i + 1] = '1';
  }  

  buffer_response[size_operador1 + 1] = '\0';
}

int main(int argc, char const *argv[])
{
  unsigned int n_entradas;
  scanf("%d", &n_entradas);

  char operador1[500], operador2[500], response[501];
  int tipo_operacao;

  scanf("%s %s %d", operador1, operador2, &tipo_operacao);

  executa_operacao_soma(response, operador1, operador2, tipo_operacao);

  printf("operador 1: %s\noperador 2: %s\noperador 3: %s\n", operador1, operador2, response);

  return 0;
}
