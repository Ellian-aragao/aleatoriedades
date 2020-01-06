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

        // introdução a herança
        // terminar de criar o gerente
        Gerente tomas = new Gerente();
        tomas.setNome("tomas");
        

        
    }
}