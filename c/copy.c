#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define READ "r"
#define WRITE "w"

int copy(char* inputPath, char* outputPath) {
    FILE *inputFile  = fopen(inputPath,"r");
    FILE *outputFile = fopen(outputPath, "w");


    fclose(inputFile);
    fclose(outputFile);
    return -1;
}

FILE* fileDeclaration(const char *path, const char *mode) {
    FILE *ptr = fopen(path, mode);
    if (ptr == NULL) {
        perror ("error to open file");
    }
    return ptr;
}

int main(int argc, char* argv[]) {
    
    char name[] = "C Language";
    unsigned long tam_name = sizeof(name) / sizeof(name[0]);
    char name_cpy[tam_name];

    FILE *ptr = fileDeclaration(argv[1], READ);

    // unsigned long n = 0;
    // while (!feof(ptr)){
    //     n++;
    //     (char*)ptr++;
    // }
    // printf("%ld\n",n);
    
    fclose(ptr);

    memcpy(name_cpy, name, tam_name);
    printf("%s\n",name_cpy);

    return 0;
}