package exception;

public class SaldoInsuficienteException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -2430274445958488945L;

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }

}
