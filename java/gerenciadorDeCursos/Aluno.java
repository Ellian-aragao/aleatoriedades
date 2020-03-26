public class Aluno {
    private String nome;
    private int numeroDaMatricula;
    
    public Aluno(String nome, int numeroDaMatricula) {
        this.nome = nome;
        this.numeroDaMatricula = numeroDaMatricula;
    }
    
    public String getNome() {
        return this.nome;
    }
    public int getNumeroDaMatricula() {
        return numeroDaMatricula;
    }

    @Override
    public boolean equals(Object obj) {
        Aluno outro = (Aluno) obj;
        return this.nome.equals(outro.nome);
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }

    @Override
    public String toString() {
        return "[Aluno: " + this.nome + ", matricula: " + this.numeroDaMatricula + "]";
    }
}
