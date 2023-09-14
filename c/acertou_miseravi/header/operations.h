#ifndef OPERATIONS_H
#define OPERATIONS_H

void execute_operation_from_type_operation(char *buffer_response, const char *operador1, const char *operador2, int tipo_operacao);

void executa_operacao_soma(char *buffer_response, const char *operador1, const char *operador2);
void executa_operacao_subtracao(char *buffer_response, const char *operador1, const char *operador2);
void executa_operacao_multiplicacao(char *buffer_response, const char *operador1, const char *operador2);

#endif