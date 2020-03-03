package testes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {

        OutputStream binario = new FileOutputStream("aleatoriedades/java/java-io/textoEscrito.txt");
        Writer interpretador = new OutputStreamWriter(binario);
        BufferedWriter escritor = new BufferedWriter(interpretador);

        escritor.write("teste de escrita de texto");
        escritor.newLine();
        escritor.write("outro teste de escrita depois de pular uma linha");
        
        escritor.close(); 
    }
}