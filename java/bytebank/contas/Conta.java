package contas;

import exception.SaldoInsuficienteException;

public abstract class Conta extends Object implements Comparable<Conta> {
    protected double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total;

    public Conta (int agencia, int numero) {
        total++;
        System.out.println("O total de contas e " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        System.out.println("Estou criando uma conta " + this.numero);
    }

    public abstract void deposita (double valor);

    public void saca(double valor) {
        if (this.saldo <= valor) {
            throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", Valor: " + valor);
        }
        this.saldo -= valor;
    }

    public void tranfere (double valor, Conta destino) {
        this.saca(valor);
        destino.deposita(valor);
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
    public Cliente getCliente () {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public int compareTo(Conta outraConta) {
        return Double.compare(this.saldo, outraConta.saldo);
    }
}