package alura.bytebank;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario lucas = new Funcionario();
        lucas.setNome("lucas");
        lucas.setSalario(2500);
        lucas.setCpf("22335566-9");

        System.out.println("funcionario");
        System.out.println("nome: " + lucas.getNome());
        System.out.println("CPF: " + lucas.getCpf());
        System.out.println("Salario: " + lucas.getSalario());
        System.out.println("Bonificacao: " + lucas.getBonificacao());

        System.out.println("-------------------------------");

        // introdução a herança
        Gerente tomas = new Gerente();
        tomas.setNome("tomas");
        tomas.setSalario(3000);
        tomas.setCpf("998877664-0");
        tomas.setSenha(2222);

        System.out.println("funcionario gerente");
        System.out.println("nome: " + tomas.getNome());
        System.out.println("senha: " + tomas.autentica(2222));
        System.out.println("CPF: " + tomas.getCpf());
        System.out.println("Salario: " + tomas.getSalario());
        System.out.println("Bonificacao: " + tomas.getBonificacao());

        System.out.println("-------------------------");

        // introdução a polimofismo
        Funcionario marcos = new Gerente();
        marcos.setNome("marcos");
        marcos.setSalario(3500);
        marcos.setCpf("045987632-25");
        ((Gerente)marcos).setSenha(1515);

        System.out.println("funcionario gerente polimofirmos");
        System.out.println("nome: " + marcos.getNome());
        System.out.println("senha: " + ((Gerente)marcos).autentica(1515));
        System.out.println("CPF: " + marcos.getCpf());
        System.out.println("Salario: " + marcos.getSalario());
        System.out.println("Bonificacao: " + marcos.getBonificacao());
    }
}