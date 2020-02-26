package testes;

import contas.Conta;
import contas.tipo.*;
import exception.SaldoInsuficienteException;

public class TesteContas {
    public static void main (String[] args) {
        Conta cc = new ContaCorrente(111, 111);
        cc.deposita(100);

        Conta cp = new ContaPoupanca(222, 222);
        cp.deposita(200); 

        try {
            cc.tranfere(100, cp);
        } catch (SaldoInsuficienteException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }

        System.out.println("Conta corrente: " + cc.getSaldo());
        System.out.println("Conta poupanca: " + cp.getSaldo());
    }
}