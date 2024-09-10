package br.edu.univille.br.spa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Long descricao;
    private Boolean finalizado;
    private Date dataPrevista;
    private Date dataFinalizacao;

}

