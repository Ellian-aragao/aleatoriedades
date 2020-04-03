import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Function;

public class HashSetVsLinkedList {

    public static void main(String[] args) {
        teste();
    }

    public static void teste()  {
        Collection<Integer> numerosHashSet = new HashSet<Integer>();
        Collection<Integer> numerosArrayList = new ArrayList<Integer>();
        Collection<Integer> numerosLinkedList = new LinkedList<Integer>();

        Collection numerosType[] = {numerosHashSet,numerosArrayList, numerosLinkedList};

        System.out.println("HashSet, ArrayList, LinkedList");
        System.out.println("------------------------------");

        for (Collection<Integer> numeros : numerosType) {
            long inicio = System.currentTimeMillis();

            for (int i = 1; i <= 50000; i++) {
                numeros.add(i);
            }

            long incersao = System.currentTimeMillis();
            System.out.println("inclusao: " + (incersao - inicio) + "ms");

            for (Integer numero : numeros) {
                numeros.contains(numero);
            }
            
            long fim = System.currentTimeMillis();

            System.out.println("verificacao: " + (fim - incersao) + "ms");

            long tempoDeExecucao = fim - inicio;

            System.out.println("Tempo gasto: " + tempoDeExecucao + "ms");
            System.out.println("-------------------");
        }
    }
}