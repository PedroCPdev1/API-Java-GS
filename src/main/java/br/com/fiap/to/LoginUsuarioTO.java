package br.com.fiap.to;

import io.smallrye.common.constraint.NotNull;

import java.time.LocalDate;

public class LoginUsuarioTO {
    private Long id_usuario;
    @NotNull
    private String email;
    @NotNull
    private String senha;

    public LoginUsuarioTO() {
    }

    public LoginUsuarioTO(String email, Long id_usuario, String senha) {
        this.email = email;
        this.id_usuario = id_usuario;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}