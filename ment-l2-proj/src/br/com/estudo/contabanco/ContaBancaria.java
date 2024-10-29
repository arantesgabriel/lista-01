package br.com.estudo.contabanco;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("deposito de r$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("valor de deposito deve ser positivo.");
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("saldo insuficiente para o saque de r$ " + valor);
        } else {
            saldo -= valor;
            System.out.println("saque de r$ " + valor + " realizado com sucesso.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
