package br.com.estudo.calcdiahora;

import java.time.LocalDateTime;
import java.time.Duration;

public class CalculadoraDeDias {

    public static long calcularDiasEntre(LocalDateTime dataInicial, LocalDateTime dataFinal) throws DataInvalidaException {
        if (dataInicial.isAfter(dataFinal)) {
            throw new DataInvalidaException("a data inicial n pode ser maior que a data final.");
        }
        return Duration.between(dataInicial, dataFinal).toDays();
    }
}

