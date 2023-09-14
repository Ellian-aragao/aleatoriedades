#include "../header/sum.h"

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

  int buffer_last_element = size_operador1 < size_operador2 ? size_operador1 : size_operador2;

  buffer_response[buffer_last_element + 1] = '\0';
}