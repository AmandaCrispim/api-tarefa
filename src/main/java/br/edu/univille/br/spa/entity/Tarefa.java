package br.edu.univille.br.spa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Tarefa {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(length = 1000)
    private String descricao;

    private Boolean finalizado = false;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPrevista;

    @Temporal(TemporalType.DATE)
    private Date dataFinalizacao;

}



