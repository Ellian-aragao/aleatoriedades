public class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total;

    public Conta (int agencia, int numero) {
        conta.total++;
        System.out.println("O total de contas e " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        System.out.println("Estou criando uma conta " + this.numero);
    }

    public void deposita (double valor) {
        this.saldo += valor;
    }

    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean tranfere (double valor, Conta destino) {
        if (this.saca(valor)) {
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero() {
        return this.numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setNumero(int numero) {
        if (numero <= 0) {
            System.out.println("Nao pode ser menor igual a 0");
            return;
        }
        this.numero = numero;
    }
    
    public void setAgencia(int agencia) {
        if (agencia <= 0) {
            System.out.println("valor deve ser maior que 0");
            return;
        }
        this.agencia = agencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}