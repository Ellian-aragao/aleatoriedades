package estrutura;

import java.util.ArrayList;
import java.util.LinkedList;

import contas.Conta;
import contas.tipo.ContaCorrente;
import contas.tipo.ContaPoupanca;

public class EstruturaTeste {
    public static void main(String[] args) {
        
        // lista organizada como vetor
        ArrayList<Conta> contas = new ArrayList<Conta>();
        // lista organizada atraves de ponteiros
        LinkedList<Conta> contas1 = new LinkedList<Conta>();
        

        Conta cc = new ContaCorrente(1, 2525);
        Conta cp = new ContaPoupanca(1, 2626);

        // possuem os mesmos métodos
        contas.add(cc);
        contas1.add(cc);
        contas.add(cp);
        contas1.add(cp);


    }
}