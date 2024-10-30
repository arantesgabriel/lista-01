package br.com.estudo.sislogin;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("lucas.cardoso", "2311");

        try {
            usuario.validarLogin("lucas.cardoso", "2311");
            System.out.println("login realizado com sucesso");
        } catch (LoginInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            usuario.validarLogin("lucas.cardoso", "2312");
        } catch (LoginInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
