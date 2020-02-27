package estrutura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

import contas.Conta;
import contas.tipo.ContaCorrente;
import contas.tipo.ContaPoupanca;

public class EstruturaListas {
    public static void main(String[] args) {

        // lista organizada como vetor
        ArrayList<Conta> arrayContas = new ArrayList<Conta>();
        // lista organizada atraves de ponteiros
        LinkedList<Conta> linkedContas = new LinkedList<Conta>();

        for (int i = 0, j = 7; i < 2; i++, j--) {
        
            Conta cc = new ContaCorrente(i + j, i + 7 * j);
            Conta cp = new ContaPoupanca(i + j -2, i + j * 3);

            arrayContas.add(cc);
            arrayContas.add(cp);
            linkedContas.add(cc);
            linkedContas.add(cp);
        }


        System.out.println("arraylist");
        for (Conta conta : arrayContas) {
            System.out.println(conta);
        }
        System.out.println("linkedlist");
        for (Conta conta : linkedContas) {
            System.out.println(conta);
        }

        System.out.println("-----------------");
        Comparador compare = new Comparador();
        arrayContas.sort(compare);
        linkedContas.sort(compare);
        
        System.out.println("arraylist");
        for (Conta conta : arrayContas) {
            System.out.println(conta);
        }
        System.out.println("linkedlist");
        for (Conta conta : linkedContas) {
            System.out.println(conta);
        }


    }
}


class Comparador implements Comparator<Conta> {

    @Override
    public int compare(Conta c1, Conta c2) {
        return Integer.compare(c1.getNumero(), c2.getNumero());
    }
    
}