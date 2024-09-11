package br.edu.univille.br.spa.service;

import br.edu.univille.br.spa.entity.Tarefa;
import br.edu.univille.br.spa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa inserir(Tarefa tarefa) {
        if (tarefa.getTitulo().length() < 5) {
            throw new IllegalArgumentException("O título deve conter pelo menos 5 caracteres");
        }
        tarefa.setFinalizado(false); // Nova tarefa não está finalizada
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> consultarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa consultarPorId(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        if (tarefaExistente.getFinalizado()) {
            throw new IllegalStateException("Não é possível modificar uma tarefa já finalizada");
        }

        if (tarefaAtualizada.getTitulo().length() < 5) {
            throw new IllegalArgumentException("O título deve conter pelo menos 5 caracteres");
        }

        tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
        tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
        tarefaExistente.setDataPrevista(tarefaAtualizada.getDataPrevista());
        return tarefaRepository.save(tarefaExistente);
    }

    public void deletar(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        if (tarefa.getFinalizado()) {
            throw new IllegalStateException("Não é possível excluir uma tarefa já finalizada");
        }
        tarefaRepository.delete(tarefa);
    }

    public List<Tarefa> consultarTarefasNaoFinalizadas() {
        return tarefaRepository.findByFinalizadoFalse();
    }

    public List<Tarefa> consultarTarefasFinalizadas() {
        return tarefaRepository.findByFinalizadoTrue();
    }

    public List<Tarefa> consultarTarefasAtrasadas() {
        return tarefaRepository.findByFinalizadoFalseAndDataPrevistaBefore(new Date());
    }

    public List<Tarefa> consultarTarefasNaoFinalizadasEntreDatas(Date start, Date end) {
        return tarefaRepository.findByFinalizadoFalseAndDataPrevistaBetween(start, end);
    }

    public Tarefa finalizarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada"));
        if (!tarefa.getFinalizado()) {
            tarefa.setFinalizado(true);
            tarefa.setDataFinalizacao(new Date());
            return tarefaRepository.save(tarefa);
        }
        return tarefa;
    }
}

