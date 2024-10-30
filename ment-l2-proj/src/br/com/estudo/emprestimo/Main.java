package br.com.estudo.emprestimo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        testarEmprestimo();
    }

    private static void testarEmprestimo() {
        LocalDate hoje = LocalDate.now();

        // test dif cenario de emprestimo
        Object[][] parametrosEmprestimos = {
                {1000.0, hoje, hoje.plusMonths(12)}, // valido
                {-500.0, hoje, hoje.plusMonths(12)}, // valor negativo
                {1000.0, hoje, hoje.minusDays(1)}, // data de vencimento passada
                {1000.0, hoje.plusDays(1), hoje.plusMonths(12)} // data de solicitacao futura
        };

        for (Object[] parametros : parametrosEmprestimos) {
            try {
                double valor = (double) parametros[0];
                LocalDate dataSolicitacao = (LocalDate) parametros[1];
                LocalDate dataVencimento = (LocalDate) parametros[2];

                Emprestimo emprestimo = new Emprestimo(valor, dataSolicitacao, dataVencimento);
                double juros = emprestimo.calcularJuros(12);
                System.out.println("Valor dos juros: " + juros);

            } catch (EmprestimoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
