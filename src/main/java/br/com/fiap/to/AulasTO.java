package br.com.fiap.to;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

public class AulasTO {
    private Long id_curso;
    private Long id_aula;
    @NotNull
    private String titulo;
    @NotNull
    private Long duracao_min;

    public AulasTO() {
    }

    public AulasTO(Long duracao_min, Long id_aula, Long id_curso, String titulo) {
        this.duracao_min = duracao_min;
        this.id_aula = id_aula;
        this.id_curso = id_curso;
        this.titulo = titulo;
    }

    public Long getDuracao_min() {
        return duracao_min;
    }

    public void setDuracao_min(Long duracao_min) {
        this.duracao_min = duracao_min;
    }

    public Long getId_aula() {
        return id_aula;
    }

    public void setId_aula(Long id_aula) {
        this.id_aula = id_aula;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}




