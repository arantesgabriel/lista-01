import domain.Pessoa;
import exception.DataFuturaException;
import service.PessoaService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DataFuturaException {

        try {
            PessoaService pessoaService = new PessoaService();
            Pessoa pessoa = new Pessoa();
            Scanner sc = new Scanner(System.in);

            System.out.print("Informe seu nome:\n");
            pessoa.setNome(sc.nextLine());

            System.out.print("Informe sua data de nascimento:\n");
            System.out.print("Utilize o formato dd/MM/yyy HH:mm\n");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(sc.nextLine(), formatter);
            pessoa.setDataNascimento(dateTime);

            Integer idade = pessoaService.calcularIdade(pessoa);

            if (idade < 0) {
                throw new DataFuturaException("Informe uma data anterior a de hoje.");
            }

            if (idade < 1) {
                pessoa.getDataNascimento().until(LocalDateTime.now(), ChronoUnit.MONTHS);
            } else System.out.print(pessoa.getNome() + ", você tem " + idade + " anos.");

        } catch (DataFuturaException e) {
            throw new DataFuturaException("Data incorreta: " + e.getMessage());
        }

    }

}