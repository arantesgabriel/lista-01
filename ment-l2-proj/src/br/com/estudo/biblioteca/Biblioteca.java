package br.com.estudo.biblioteca;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivrosPublicadosComInformacao() {
        LocalDateTime dezAnosAtras = LocalDateTime.now().minusYears(10);

        List<Livro> livrosRecentes = livros.stream()
                .filter(livro -> livro.getDataPublicacao().isAfter(dezAnosAtras))
                .toList();

        if (livrosRecentes.isEmpty()) {
            System.out.println("nenhum livro publicado nos ultimos 10 anos.");
        } else {
            System.out.println("livros publicados nos ultimos 10 anos:");
            livrosRecentes.forEach(System.out::println);
        }

        List<Livro> livrosAntigos = livros.stream()
                .filter(livro -> livro.getDataPublicacao().isBefore(dezAnosAtras))
                .toList();

        if (!livrosAntigos.isEmpty()) {
            System.out.println("\nlivros publicados ha mais de 10 anos:");
            livrosAntigos.forEach(livro -> {
                long anos = ChronoUnit.YEARS.between(livro.getDataPublicacao(), LocalDateTime.now());
                System.out.println(livro + " - publicado ha " + anos + " anos");
            });
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) throws LivroNaoEncontradoException {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new LivroNaoEncontradoException("livro com titulo '" + titulo + "' nao encontrado."));
    }
}
