package br.com.estudo.calcdiahora;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataInicial = LocalDateTime.of(2002, 11, 23, 0, 0);
        LocalDateTime dataFinal = LocalDateTime.of(2024, 10, 30, 0, 0);

        try {
            long dias = CalculadoraDeDias.calcularDiasEntre(dataInicial, dataFinal);
            System.out.println("qtd de dias entre as datas: " + dias);
        } catch (DataInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }
}

