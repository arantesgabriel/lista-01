package br.com.estudo.agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Compromisso> compromissos;

    public Agenda() {
        this.compromissos = new ArrayList<>();
    }

    public void adicionarCompromisso(Compromisso compromisso){
        compromissos.add(compromisso);
    }

    public void listarCompromissos() {
        if (compromissos.isEmpty()) {
            System.out.println("nenhum compromisso agendado.");
        } else {
            for (Compromisso compromisso : compromissos) {
                System.out.println(compromisso);
            }
        }
    }

}
