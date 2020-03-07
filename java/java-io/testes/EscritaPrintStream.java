package testes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class EscritaPrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printa = new PrintStream(new File("aleatoriedades/java/java-io/textoEscritoPrintStream.txt"));
        printa.println("escrevendo com PrintStream");
        printa.println();
        printa.println();
        printa.println("fim brooooo");
        printa.close();
    }
}