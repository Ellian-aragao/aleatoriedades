import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Leitor {
    public static void main(String[] args) {
        
        try {
            
            FileInputStream arquivo = new FileInputStream("teste.txt");
            InputStreamReader isr = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(isr);

            String linha;

            do {
                
                linha = br.readLine();
                if (linha != null) {
                    System.out.println("LIDO --> " + linha);
                }

            } while (linha != null);


            br.close();
            isr.close();
            arquivo.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}