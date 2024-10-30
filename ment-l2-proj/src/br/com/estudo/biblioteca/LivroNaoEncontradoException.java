package br.com.estudo.biblioteca;

public class LivroNaoEncontradoException extends Exception {
  public LivroNaoEncontradoException(String mensagem) {
    super(mensagem);
  }
}

