package br.edu.univille.br.spa.controller;

import br.edu.univille.br.spa.entity.Tarefa;
import br.edu.univille.br.spa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaRestController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa inserir(@RequestBody Tarefa tarefa) {
        return tarefaService.inserir(tarefa);
    }

    @GetMapping
    public List<Tarefa> consultarTodas() {
        return tarefaService.consultarTodas();
    }

    @GetMapping("/{id}")
    public Tarefa consultarPorId(@PathVariable Long id) {
        return tarefaService.consultarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }

    @GetMapping("/nao-finalizadas")
    public List<Tarefa> consultarNaoFinalizadas() {
        return tarefaService.consultarTarefasNaoFinalizadas();
    }

    @GetMapping("/finalizadas")
    public List<Tarefa> consultarFinalizadas() {
        return tarefaService.consultarTarefasFinalizadas();
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> consultarAtrasadas() {
        return tarefaService.consultarTarefasAtrasadas();
    }

    @GetMapping("/nao-finalizadas-entre-datas")
    public List<Tarefa> consultarNaoFinalizadasEntreDatas(@RequestParam Date inicio, @RequestParam Date fim) {
        return tarefaService.consultarTarefasNaoFinalizadasEntreDatas(inicio, fim);
    }

    @PutMapping("/finalizar/{id}")
    public Tarefa finalizarTarefa(@PathVariable Long id) {
        return tarefaService.finalizarTarefa(id);
    }
}
