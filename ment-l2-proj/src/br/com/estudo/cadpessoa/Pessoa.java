package br.com.estudo.cadpessoa;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


public class Pessoa {
    private final String nome;
    private final LocalDateTime dataNascimento;

    // validacao data nasciment
    public Pessoa(String nome, LocalDateTime dataNascimento) {
        validarDataNascimento(dataNascimento);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // verifica se a data de nasc e valida
    private void validarDataNascimento(LocalDateTime dataNascimento) {
        if (dataNascimento.isAfter(LocalDateTime.now())) {
            throw new DataFuturaException("A data de nascimento não pode estar no futuro.");
        }
    }
    // calc idade
    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = this.dataNascimento.toLocalDate();
        return Period.between(dataNascimento, dataAtual).getYears();
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return String.format("Pessoa{nome='%s', dataNascimento=%s, idade=%d anos}",
                nome, dataNascimento.toLocalDate(), calcularIdade());
    }
}



