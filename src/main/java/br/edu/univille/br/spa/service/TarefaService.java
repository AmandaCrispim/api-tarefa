package br.edu.univille.br.spa.service;


import br.edu.univille.br.spa.entity.Tarefa;
import br.edu.univille.br.spa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> obterTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> obterPeloId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa incluir(Tarefa tarefa) {
        tarefa.setId(0L);

        // Validações
        if (String.isBlank(tarefa.getTitulo())) {
            throw new RuntimeException("Título não informado.");
        }
        if (tarefa.getTitulo().length() < 5) {
            throw new RuntimeException("O título deve ter pelo menos 5 caracteres.");
        }
        if (tarefa.getDataPrevista() == null) {
            throw new RuntimeException("Data prevista de finalização não informada.");
        }

        tarefa.setFinalizado(false);
        tarefa.setDataFinalizacao(null);

        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Tarefa tarefa) {
        Tarefa antiga = tarefaRepository.findById(tarefa.getId()).orElse(null);

        if (antiga == null) {
            throw new RuntimeException("Tarefa não encontrada.");
        }

        // Impede atualização de tarefas finalizadas
        if (antiga.isFinalizado()) {
            throw new RuntimeException("Tarefa finalizada não pode ser modificada.");
        }

        // Validações
        if (String.isBlank(tarefa.getTitulo())) {
            throw new RuntimeException("Título não informado.");
        }
        if (tarefa.getTitulo().length() < 5) {
            throw new RuntimeException("O título deve ter pelo menos 5 caracteres.");
        }
        if (tarefa.getDataPrevista() == null) {
            throw new RuntimeException("Data prevista de finalização não informada.");
        }

        antiga.setTitulo(tarefa.getTitulo());
        antiga.setDescricao(tarefa.getDescricao());
        antiga.setDataPrevista(tarefa.getDataPrevista());

        return tarefaRepository.save(antiga);
    }

    public void excluir(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

        if (tarefa == null) {
            throw new RuntimeException("Tarefa não encontrada.");
        }

        if (tarefa.isFinalizado()) {
            throw new RuntimeException("Tarefa finalizada não pode ser excluída.");
        }

        tarefaRepository.delete(tarefa);
    }

    public List<Tarefa> obterTarefasNaoFinalizadas() {
        return tarefaRepository.findAllByFinalizadoFalse();
    }

    public List<Tarefa> obterTarefasFinalizadas() {
        return tarefaRepository.findAllByFinalizadoTrue();
    }

    public List<Tarefa> obterTarefasAtrasadas() {
        return tarefaRepository.findAllByDataPrevistaFinalizacaoBeforeAndFinalizadoFalse(LocalDate.now());
    }

    public List<Tarefa> obterTarefasNaoFinalizadasEntreDatas(LocalDate dataInicio, LocalDate dataFim) {
        return tarefaRepository.findAllByDataPrevistaFinalizacaoBetweenAndFinalizadoFalse(dataInicio, dataFim);
    }

    public Tarefa finalizarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

        if (tarefa == null) {
            throw new RuntimeException("Tarefa não encontrada.");
        }

        if (tarefa.isFinalizado()) {
            throw new RuntimeException("Tarefa já está finalizada.");
        }

        tarefa.setFinalizado(true);
        tarefa.setDataFinalizacao(LocalDate.now());

        return tarefaRepository.save(tarefa);
    }



