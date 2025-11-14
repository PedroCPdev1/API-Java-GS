package br.com.fiap.to;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

public class PerfilTO {
    private Long id_usuario;
    @NotNull
    private LocalDate data_criacao;
    @NotNull
    private String nome;
    @NotNull
    private String profissao;

    public PerfilTO() {
    }

    public PerfilTO(LocalDate data_criacao, Long id_usuario, String nome, String profissao) {
        this.data_criacao = data_criacao;
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.profissao = profissao;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
