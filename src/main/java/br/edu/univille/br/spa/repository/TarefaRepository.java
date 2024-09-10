package br.edu.univille.br.spa.repository;

import br.edu.univille.br.spa.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByTituloContaining(String titulo);

    List<Tarefa> findByDataPrevista(String dataPrevista);
}
