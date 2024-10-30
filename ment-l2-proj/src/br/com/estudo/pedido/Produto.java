package br.com.estudo.pedido;

import java.time.LocalDateTime;
import java.time.Period;

public class Produto {
    private String nome;
    private LocalDateTime dataInclusao;

    public Produto(String nome, LocalDateTime dataInclusao) {
        this.nome = nome;
        this.dataInclusao = dataInclusao;
    }

    public Produto(String nome) {
        this.nome = nome;
        this.dataInclusao = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public boolean isRecente() {
        Period periodo = Period.between(dataInclusao.toLocalDate(), LocalDateTime.now().toLocalDate());
        return periodo.getDays() <= 7 && periodo.getMonths() == 0 && periodo.getYears() == 0;
    }

    @Override
    public String toString() {
        return nome + " (incluido em: " + dataInclusao + ")";
    }
}

