import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LeitorEscritor {
    public static void main(String[] args) {
        
        try {
            
            FileInputStream arquivo = new FileInputStream("teste.txt");
            InputStreamReader isr = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(isr);

            FileOutputStream txt = new FileOutputStream("arqFinal.txt");
            PrintWriter pw = new PrintWriter(txt);
            
            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    System.out.println("LIDO --> " + linha);

                    String[] palavras = linha.split(";");
                    
                    for (int i = 0; i < palavras.length; i++) {
                        pw.println(palavras[i]);
                    }
                }
            } while (linha != null);

            pw.close();
            txt.close();

            br.close();
            isr.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}