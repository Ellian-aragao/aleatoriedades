import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestandoListaDeAulas {
    public static void main(String[] args) {
        Aula a1 = new Aula("testando listas", 21);
        Aula a2 = new Aula("criando lista de aulas", 15);
        Aula a3 = new Aula("trabalhando com collections", 17);

        ArrayList<Aula> aulas = new ArrayList<>();
        
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);
        
        System.out.println(aulas);

        Collections.sort(aulas);
        System.out.println(aulas);

        Collections.sort(aulas, Comparator.comparing(Aula::getTempo));
        System.out.println(aulas);
    }
}