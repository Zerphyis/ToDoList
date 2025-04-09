package dev.Zerphyis.toDoList.Controller;

import dev.Zerphyis.toDoList.Entitys.Status;
import dev.Zerphyis.toDoList.Entitys.Tasks;
import dev.Zerphyis.toDoList.Records.DataTask;
import dev.Zerphyis.toDoList.Service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tarefas")
public class TasksController {
    @Autowired
    TasksService service;

    @PostMapping
    public Tasks criarTarefa(@RequestBody  DataTask data) {
        return service.salvar(data);
    }

    @GetMapping
    public List<Tasks> listarTarefas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Tasks buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tasks atualizarTarefa(@PathVariable Long id, @RequestBody  DataTask data) {
        return service.atualizar(id, data);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/status/{status}")
    public List<Tasks> listarPorStatus(@PathVariable Status status) {
        return service.listarPorStatus(status);
    }

    @GetMapping("/atrasadas")
    public List<Tasks> listarAtrasadas() {
        return service.listarAtrasadas();
    }
}
