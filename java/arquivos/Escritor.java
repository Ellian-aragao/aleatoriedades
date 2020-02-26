import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Escritor {
    public static void main (String[] args) {
        
        // obrigatório para manipulação de arquivos
        try {
            
            FileOutputStream arquivo = new FileOutputStream("teste.txt");
            PrintWriter pw = new PrintWriter(arquivo);
            
            // imprime uma matriz
            for (int i = 0; i < 3; i++) {
                
                for (int j = 0; j < 3; j++) {
                    String str = "linha: " + i + "  coluna: " + j + ";\t";
                    pw.print(str);
                    System.out.println(str);
                }
                
                pw.println("");
                System.out.println("");
            }
            
            // fecha os objetos para salvar os dados
            pw.close();
            arquivo.close();

        } catch (Exception e) {

            System.out.println("erro");
        }
    }
}