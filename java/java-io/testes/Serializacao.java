package testes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacao {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //escrita de dados em binario
        String nome = "ellian_aragao";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.bin"));
        oos.writeObject(nome);
        oos.close();

        //leitura de dados em binario
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.bin"));
        String teste = (String) ois.readObject();
        System.out.println(teste);
        ois.close();
    }
}