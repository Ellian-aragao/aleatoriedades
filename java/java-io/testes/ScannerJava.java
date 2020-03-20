package testes;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ScannerJava {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("aleatoriedades/java/java-io/teste.csv"));
        while(sc.hasNextLine()){
            String linha = sc.nextLine();
            System.out.println(linha);

            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useLocale(Locale.US);
            linhaScanner.useDelimiter(",");
            String valor = linhaScanner.next();
            System.out.println(valor);
            System.out.format("linha -> %s, valor -> %s",linha,valor);
            linhaScanner.close();

            String[] valores = linha.split(",");
            System.out.println(Arrays.toString(valores));
        }
        sc.close();
    }
}