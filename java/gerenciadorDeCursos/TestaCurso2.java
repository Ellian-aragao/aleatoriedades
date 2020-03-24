import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {
    public static void main(String[] args) {
        Curso javaColencoes = new Curso("dominando as coleções do java", "Paulo Silveira");
        javaColencoes.adiciona(new Aula("trabalhando com ArrayList", 21));
        javaColencoes.adiciona(new Aula("criando uma aula", 20));
        javaColencoes.adiciona(new Aula("modelando coleções", 22));
        System.out.println(javaColencoes.getAulas());

        List<Aula> aulasMutaveis = new ArrayList<>(javaColencoes.getAulas());
        Collections.sort(aulasMutaveis);
        System.out.println(aulasMutaveis);
        System.out.println(javaColencoes.getTempoAulas());
    }
}