package br.com.fiap.to;

import io.smallrye.common.constraint.NotNull;

import java.time.LocalDate;

public class CursosTO {
    private Long id_curso;
    private Long id_professor;
    @NotNull
    private LocalDate data_conclusao;
    @NotNull
    private String situacao_conclusao;
    @NotNull
    private String titulo;

    public CursosTO() {

    }

    public CursosTO(LocalDate data_conclusao, Long id_curso, Long id_professor, String situacao_conclusao, String titulo) {
        this.data_conclusao = data_conclusao;
        this.id_curso = id_curso;
        this.id_professor = id_professor;
        this.situacao_conclusao = situacao_conclusao;
        this.titulo = titulo;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public Long getId_professor() {
        return id_professor;
    }

    public void setId_professor(Long id_professor) {
        this.id_professor = id_professor;
    }

    public LocalDate getData_conclusao() {
        return data_conclusao;
    }

    public void setData_conclusao(LocalDate data_conclusao) {
        this.data_conclusao = data_conclusao;
    }

    public String getSituacao_conclusao() {
        return situacao_conclusao;
    }

    public void setSituacao_conclusao(String situacao_conclusao) {
        this.situacao_conclusao = situacao_conclusao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}




