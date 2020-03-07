package testes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {

        InputStream binario = new FileInputStream("aleatoriedades/java/java-io/texto.txt");
        Reader interpretador = new InputStreamReader(binario);
        BufferedReader leitorDeLinhas = new BufferedReader(interpretador);

        String linha = leitorDeLinhas.readLine();
        while (linha != null) {
            System.out.println(linha);
            linha = leitorDeLinhas.readLine();
        }
        leitorDeLinhas.close(); 
    }
}