package br.com.estudo.biblioteca;

import java.time.LocalDateTime;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDateTime dataPublicacao;

    public Livro(String titulo, String autor, LocalDateTime dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
