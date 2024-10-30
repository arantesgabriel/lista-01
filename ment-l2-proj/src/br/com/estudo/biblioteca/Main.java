package br.com.estudo.biblioteca;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("harry potter e a pedra filosofal", "j k rowling", LocalDateTime.of(1999, 10, 14, 0, 0));
        Livro livro2 = new Livro("senhor dos aneis", "j r r tolkien", LocalDateTime.of(1954, 6, 29, 0, 0));
        Livro livro3 = new Livro("o pequeno principe", "antoine de saint", LocalDateTime.of(1943, 4, 6, 0, 0));

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);

        biblioteca.listarLivrosPublicadosComInformacao();

        // buscar o livro aqui
        try {
            System.out.println("\nbuscando o livro 'harry potter e a pedra filosofal':");
            System.out.println(biblioteca.buscarLivroPorTitulo("harry potter e a pedra filosofal"));
        } catch (LivroNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}
