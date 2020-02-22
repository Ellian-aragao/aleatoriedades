package estrutura;

import contas.Conta;
import contas.tipo.ContaCorrente;

public class EstruturaTeste {
    public static void main(String[] args) {
        Conta estruturaDeContas[] = new Conta[5];
        
        for (int i = 0; i < estruturaDeContas.length; i++) {
            ContaCorrente cc = new ContaCorrente(i + 1, i + 1025);
            estruturaDeContas[i] = cc;
        }

        System.out.println("_________MOSTRANDO CONTAS__________");

        for (int i = 0; i < estruturaDeContas.length; i++) {
            System.out.println(estruturaDeContas[i]);
        }
    }
}