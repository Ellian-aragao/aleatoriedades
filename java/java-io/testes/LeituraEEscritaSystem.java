package testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class LeituraEEscritaSystem {
    public static void main(String[] args) throws IOException {
        
        InputStream binario_in = System.in;
        Reader interpretador_in = new InputStreamReader(binario_in);
        BufferedReader leitorDeLinhas = new BufferedReader(interpretador_in);

        OutputStream binario_out = System.out;
        Writer interpretador_out = new OutputStreamWriter(binario_out);
        BufferedWriter escritor = new BufferedWriter(interpretador_out);
        
        String linha = leitorDeLinhas.readLine();
        while (linha != null && !linha.isEmpty()) {
            escritor.write(linha);
            escritor.newLine();
            //escritor.flush();
            linha = leitorDeLinhas.readLine();
        }

        escritor.close(); 
        leitorDeLinhas.close(); 
    }
}