package br.com.estudo.emprestimo;

import java.time.LocalDate;
import java.time.Period;

public class Emprestimo {
    private double valor;
    private LocalDate dataSolicitacao;
    private LocalDate dataVencimento;

    public Emprestimo(double valor, LocalDate dataSolicitacao, LocalDate dataVencimento) throws EmprestimoInvalidoException {
        validarValor(valor);
        validarDataVencimento(dataVencimento);

        this.valor = valor;
        this.dataSolicitacao = dataSolicitacao;
        this.dataVencimento = dataVencimento;
    }

    private void validarValor(double valor) throws EmprestimoInvalidoException {
        if (valor <= 0) {
            throw new EmprestimoInvalidoException("o valor do emprestimo deve ser positivo");
        }
    }

    private void validarDataVencimento(LocalDate dataVencimento) throws EmprestimoInvalidoException {
        if (dataVencimento.isBefore(LocalDate.now())) {
            throw new EmprestimoInvalidoException("a data de vencimento nao pode ser anterior a data atual");
        }
    }

    public double calcularJuros(double taxaAnual) {
        Period periodo = Period.between(dataSolicitacao, dataVencimento);
        int meses = periodo.getYears() * 12 + periodo.getMonths();
        double taxaMensal = taxaAnual / 12 / 100;
        return valor * Math.pow(1 + taxaMensal, meses) - valor;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    @Override
    public String toString() {
        return String.format("Emprestimo{valor=%.2f, dataSolicitacao=%s, dataVencimento=%s}",
                valor, dataSolicitacao, dataVencimento);
    }
}
