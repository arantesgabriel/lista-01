package br.com.estudo.gerenaluno;

import java.util.List;

public class Aluno {
    private String nome;
    private String matricula;
    private List<Double> notas;

    public Aluno(String nome, String matricula, List<Double> notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public double calcularMedia() throws SemNotaException {
        if (notas == null || notas.isEmpty()) {
            throw new SemNotaException("o aluno nao possui notas cadastradas.");
        }
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public boolean isAprovado() throws SemNotaException {
        return calcularMedia() >= 7.0;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Double> getNotas() {
        return notas;
    }
}
