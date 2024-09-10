package br.edu.univille.br.spa.service;

import br.edu.univille.br.spa.repository.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    public List<Tarefa> listarTarefas(Long ID) { return tarefaRepositorio.findById(id); }
}
