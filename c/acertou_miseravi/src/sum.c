#include "../header/sum.h"

void execute_sum(char *buffer_response, const char *operador1, const char *operador2)
{
  int size_operador1 = strlen(operador1);
  int size_operador2 = strlen(operador2);

  int buffer_last_element = size_operador1 > size_operador2 ? size_operador1 : size_operador2;

  int resto = 0;
  int offset_operator1, offset_operator2, offset_writer;
  for (offset_operator1 = size_operador1, offset_operator2 = size_operador2, offset_writer = buffer_last_element; offset_operator1 >= 0 && offset_operator2 >= 0; offset_operator1--, offset_operator2--, offset_writer--)
  {
    SizeStrings values = extract_values_from_operators_iteration(operador1, operador2, offset_operator1, offset_operator2);

    int soma = values.operator1 + values.operator2 + resto;
    resto = soma % 10;

    buffer_response[offset_writer] = resto + '0';
  }

  for (; offset_operator1 >= 0; offset_operator1--, offset_writer--)
  {
    buffer_response[offset_writer] = operador1[offset_operator1];
  }

  for (; offset_operator2 >= 0; offset_operator2--, offset_writer--)
  {
    buffer_response[offset_writer] = operador1[offset_operator2];
  }

  buffer_response[buffer_last_element + 1] = '\0';
}