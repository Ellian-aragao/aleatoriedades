#include <stdio.h>
int main(int argc, char *argv[])
{
    FILE *arq = fopen(argv[1], "r");
    FILE *final_arq = fopen("finalTxt", "w");
		
	// string de início para atualizar pacote ubuntu
    char strInicio[] = "sudo apt install ";
    char strFinal[] = " -only-upgrade -y";

    fprintf(final_arq,"%s","#!/bin/bash\n");
    fprintf(final_arq, "%s", strInicio);
    char c;
    do
    {
        c = getc(arq);
        if (c == ' ')
        {
            char e = getc(arq);
            fprintf(final_arq, "%c", e);
        }
        if (c == '\n')
        {
            fprintf(final_arq,"%s",strFinal);
            fprintf(final_arq, "%c", c);
            char a = getc(arq);
            if (a == EOF) {
                break;
            }
            fprintf(final_arq,"%s",strInicio);
            fprintf(final_arq, "%c", a);
        }
        else
        {
            fprintf(final_arq, "%c", c);
        }
    } while (c != EOF);
		puts("arquivos salvos com sucesso");
    fclose(final_arq);
    fclose(arq);
    return 0;
}
