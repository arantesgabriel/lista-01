package br.com.estudo.calculadora;

public class Main {
    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        try {
            System.out.println("soma: " + calc.somar(24,25));
            System.out.println("subtracao: " + calc.subtrair(150,20));
            System.out.println("multiplicacao: " + calc.multiplicar(70,7));
            System.out.println("divisao: " + calc.dividir(25,0));
        } catch (DivisaoPorZeroException e) {
            System.out.println(e.getMessage());
        }
    }
}
