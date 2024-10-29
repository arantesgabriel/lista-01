package br.com.estudo.calculadora;

public class Calculadora {

    public double somar(double a, double b){
        return a + b;
    }

    public double subtrair(double a, double b){
        return a - b;
    }

    public double multiplicar(double a, double b){
        return a * b;
    }

    public double dividir(double a, double b) throws DivisaoPorZeroException  {
        if (b == 0) {
            throw new DivisaoPorZeroException("erro: divisao por zero nao e permitido.");
        }
        return a / b;
    }




}
