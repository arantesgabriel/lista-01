package br.com.estudo.agenda;

import java.time.LocalDateTime;
import java.util.logging.Logger;


public class Main {

    //by lord danielsRATKbr ensinamentos :D
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        try {

            Compromisso compromisso1 = new Compromisso("reuniao daily", LocalDateTime.of(2024, 10, 29, 8, 0));
            Compromisso compromisso2 = new Compromisso("jogar diablo", LocalDateTime.of(2024, 10, 29, 21, 0));

            agenda.adicionarCompromisso(compromisso1);
            agenda.adicionarCompromisso(compromisso2);
        } catch (CompromissoExpiradoException e) {
            logger.info(
                    "erro ao adicionar compromisso: "+ e.getMessage());
        }

        agenda.listarCompromissos();

    }

}
