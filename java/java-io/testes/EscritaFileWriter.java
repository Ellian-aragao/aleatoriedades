package testes;

import java.io.FileWriter;
import java.io.IOException;

public class EscritaFileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter escrita = new FileWriter("aleatoriedades/java/java-io/textoEscritoFileWriter.txt");
        escrita.write("teste de entrada de dados através do FileWriter");
        escrita.write(System.lineSeparator());
        escrita.close();
    }
}