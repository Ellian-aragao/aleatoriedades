import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
    public static void main(String[] args) {
        String aula0 = "conhencendo mais de listas 1";
        String aula1 = "modelando a calsse aula 2";
        String aula2 = "trabalhando com cursos e sets 3";
        String aula3 = "removendo elementos de lista 4";

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add(aula0);
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        for (String string : aulas) {
            System.out.println(string);
        }
    
        System.out.println("ordenando lista");
        Collections.sort(aulas);
        aulas.forEach(aula -> System.out.println("percorrendo aula: " + aula));
    }
}