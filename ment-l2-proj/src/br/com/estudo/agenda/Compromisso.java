package br.com.estudo.agenda;

import java.time.LocalDateTime;

public class Compromisso {

    private String descricao;
    private LocalDateTime dataHora;

    public Compromisso (String descricao, LocalDateTime dataHora) throws CompromissoExpiradoException {
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new CompromissoExpiradoException("o compromisso ja esta expirado.");
        }
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public String getDescricao(){
        return descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String toString() {
        return "compromisso{" +
                "descricao='" + descricao + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }

}
