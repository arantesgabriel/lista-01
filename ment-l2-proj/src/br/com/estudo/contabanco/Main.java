package br.com.estudo.contabanco;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();

        conta.depositar(1000);

        try {
            conta.sacar(1200);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo atual: R$ " + conta.getSaldo());
    }
}

