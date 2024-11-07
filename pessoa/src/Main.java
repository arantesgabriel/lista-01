import domain.Pessoa;
import exception.DataFuturaException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DataFuturaException {

        try {
            Pessoa pessoa = new Pessoa();
            Scanner sc = new Scanner(System.in);

            System.out.print("Informe seu nome: ");
            pessoa.setNome(sc.nextLine());

            System.out.print("Utilize o formato dd/MM/yyy HH:mm\n");
            System.out.print("Informe sua data de nascimento: ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(sc.nextLine(), formatter);
            pessoa.setDataNascimento(dateTime);

            int idade = LocalDateTime.now().getYear() - pessoa.getDataNascimento().getYear();

            if (idade == 0) {
                throw new DataFuturaException("Informe uma data anterior a de hoje.");
            }

            if (idade < 1) {
                System.out.print("A idade é: " + pessoa.getDataNascimento().until(LocalDateTime.now(), ChronoUnit.MONTHS) + " meses");
            } else System.out.print(pessoa.getNome() + ", você tem " + idade + " anos.");

        } catch (DataFuturaException e) {
            throw new DataFuturaException("Data incorreta: " + e.getMessage());
        }

    }
}