package estrutura;

import contas.Conta;
import contas.tipo.ContaCorrente;

public class EstruturaTeste {
    public static void main(String[] args) {
        Conta estruturaDeContas[] = new Conta[5];
        ContaCorrente cc = new ContaCorrente(0001, 1025);
        estruturaDeContas[0] = cc;
        System.out.println(estruturaDeContas[0]);

    }
}