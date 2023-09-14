PROGRAM_NAME = operations
CC = gcc
CC_FLAGS = -pedantic -Wall -Wextra -Wcast-align -Wcast-qual -Wdisabled-optimization -Wformat=2 -Winit-self -Wlogical-op -Wmissing-declarations -Wmissing-include-dirs -Wredundant-decls -Wshadow -Wsign-conversion -Wstrict-overflow=5 -Wswitch-default -Wundef -Werror -Wno-unused
H_SOURCE = $(wildcard header/*.h)
C_SOURCE = $(wildcard ./src/*.c)
TARGET_FOLDER = build
OBJ = $(subst .c,.o,$(subst src,build,$(C_SOURCE)))

build: $(OBJ)
	@echo building files $(OBJ)
	$(CC) -lm $(OBJ) -o $(PROGRAM_NAME)

build/%.o: $(C_SOURCE) $(H_SOURCE)
	@ echo 'Compilando o arquivo: $<'
	$(CC) $(CC_FLAGS) -c $< -o $@
	@ echo ' '
	@ echo 'Compilação concluída: $@'
	@ echo ' '

clean:
	@echo "cleaning up..."
	rm -rvf $(wildcard $(TARGET_FOLDER)/*.o) $(PROGRAM_NAME)