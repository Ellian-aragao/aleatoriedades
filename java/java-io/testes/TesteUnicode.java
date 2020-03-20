package testes;

import java.nio.charset.Charset;

public class TesteUnicode {
    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a);

        Charset charset = Charset.defaultCharset();
        System.out.println(charset.displayName());
    }
}