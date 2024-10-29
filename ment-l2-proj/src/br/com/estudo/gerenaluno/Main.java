package br.com.estudo.gerenaluno;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> notasAluno1 = Arrays.asList(8.0, 7.5, 9.0);
        Aluno aluno1 = new Aluno("lucas", "20240101", notasAluno1);

        List<Double> notasAluno2 = Arrays.asList();
        Aluno aluno2 = new Aluno("daniel", "20240102", notasAluno2);

        try {
            System.out.println(aluno1.getNome() + " - Média: " + aluno1.calcularMedia());
            System.out.println(aluno1.getNome() + " está aprovado? " + aluno1.isAprovado());

            System.out.println(aluno2.getNome() + " - Média: " + aluno2.calcularMedia());
            System.out.println(aluno2.getNome() + " está aprovado? " + aluno2.isAprovado());
        } catch (SemNotaException e) {
            System.out.println(e.getMessage());
        }
    }
}

