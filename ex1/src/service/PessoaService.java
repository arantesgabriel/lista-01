package service;

import domain.Pessoa;

import java.time.LocalDateTime;

public class PessoaService {

    public Integer calcularIdade(Pessoa pessoa) {
        return LocalDateTime.now().getYear() - pessoa.getDataNascimento().getYear();
    }

}
