package br.com.estudo.sislogin;

import java.time.LocalDateTime;

public class Usuario {
    private String nomeUsuario;
    private String senha;
    private LocalDateTime dataCriacaoConta;

    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.dataCriacaoConta = LocalDateTime.now();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacaoConta() {
        return dataCriacaoConta;
    }

    public void validarLogin(String nomeUsuario, String senha) throws LoginInvalidoException {
        if (!this.nomeUsuario.equals(nomeUsuario) || !this.senha.equals(senha)) {
            throw new LoginInvalidoException("nome de usuario ou senha incorretos");
        }
    }
}
