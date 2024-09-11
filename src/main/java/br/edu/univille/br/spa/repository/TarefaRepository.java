package br.edu.univille.br.spa.repository;

import br.edu.univille.br.spa.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByFinalizadoFalse();
    List<Tarefa> findByFinalizadoTrue();
    List<Tarefa> findByFinalizadoFalseAndDataPrevistaBetween(Date start, Date end);
    List<Tarefa> findByFinalizadoFalseAndDataPrevistaBefore(Date currentDate);
}
