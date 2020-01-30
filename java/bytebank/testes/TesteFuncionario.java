package testes;

import usuarios.*;

public class TesteFuncionario {
    public static void main(String[] args) {

        Funcionario tomas = new Gerente();
        tomas.setNome("tomas");
        tomas.setSalario(3000);
        tomas.setCpf("998877664-0");
        
        // cast para funcionamento do método da classe
        ((Gerente)tomas).setSenha(2222); 

        System.out.println("Gerente");
        System.out.println("nome: " + tomas.getNome());
        System.out.println("senha: " + "2222  " + ((Gerente)tomas).autentica(2222));
        SistemaInterno sys = new SistemaInterno();
        sys.autentica((Gerente)tomas);
        System.out.println("CPF: " + tomas.getCpf());
        System.out.println("Salario: " + tomas.getSalario());
        System.out.println("Bonificacao: " + tomas.getBonificacao());

        System.out.println("-------------------------");

        // introdução a polimofismo
        Funcionario marcos = new Designer();
        marcos.setNome("marcos");
        marcos.setSalario(2000);
        marcos.setCpf("045987632-25");

        System.out.println("designer");
        System.out.println("nome: " + marcos.getNome());
        System.out.println("CPF: " + marcos.getCpf());
        System.out.println("Salario: " + marcos.getSalario());
        System.out.println("Bonificacao: " + marcos.getBonificacao());

        System.out.println("-------------------------");

        Funcionario robert = new Administrador();
        robert.setNome("robert");
        robert.setSalario(3000);
        robert.setCpf("998877664-0");
        
        // cast para funcionamento do método da classe
        ((Administrador)robert).setSenha(2222); 

        System.out.println("Administrador");
        System.out.println("nome: " + robert.getNome());
        System.out.println("senha: " + "3333  " + ((Administrador)robert).autentica(3333));
        sys.autentica((Administrador)robert);
        System.out.println("CPF: " + robert.getCpf());
        System.out.println("Salario: " + robert.getSalario());
        System.out.println("Bonificacao: " + robert.getBonificacao());
    }
}