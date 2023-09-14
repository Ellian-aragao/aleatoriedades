#ifndef OPERATIONS_H
#define OPERATIONS_H

#include <stdio.h>

#include "../header/commons.h"
#include "../header/sum.h"
#include "../header/multiply.h"
#include "../header/subtraction.h"

void execute_operation_from_type_operation(char *buffer_response, const char *operador1, const char *operador2, int tipo_operacao);

#endif