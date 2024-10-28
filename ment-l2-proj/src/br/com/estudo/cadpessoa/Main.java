package br.com.estudo.cadpessoa;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        try {
            Pessoa pessoa = new Pessoa("lucas", LocalDateTime.of(2042, 11, 23, 0, 0));
            System.out.println(pessoa);
        } catch (DataFuturaException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
