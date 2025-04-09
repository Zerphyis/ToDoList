package dev.Zerphyis.toDoList.Controller;

import dev.Zerphyis.toDoList.Entitys.Status;
import dev.Zerphyis.toDoList.Entitys.Tasks;
import dev.Zerphyis.toDoList.Records.DataTask;
import dev.Zerphyis.toDoList.Service.TasksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tarefas")
public class TasksController {
    @Autowired
    TasksService service;

    @PostMapping
    public Tasks criarTarefa(@RequestBody DataTask data) {
        return service.salvar(data);
    }

    @GetMapping
    public List<Tasks> listarTarefas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Tasks buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Tasks atualizarTarefa(@PathVariable("id") Long id, @RequestBody DataTask data) {
        return service.atualizar(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletarTarefa(@PathVariable("id")Long id) {
        service.deletar(id);
    }

    @GetMapping("/status/{status}")
    @ResponseBody
    public List<Tasks> listarPorStatus(@PathVariable("status") Status status) {
        return service.listarPorStatus(status);
    }

    @GetMapping("/atrasadas")
    @ResponseBody
    public List<Tasks> listarAtrasadas() {
        return service.listarAtrasadas();
    }


    @GetMapping("/html")
    public String listarView(Model model) {
        model.addAttribute("tarefas", service.listarTodas());
        return "lista";
    }

    @GetMapping("/form")
    public String formNova(Model model) {
        model.addAttribute("tarefa", new Tasks());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String formEditar(@PathVariable Long id, Model model) {
        Tasks tarefa = service.buscarPorId(id);
        model.addAttribute("tarefa", tarefa);
        return "form";
    }

    @PostMapping("/save")
    public String salvar(@ModelAttribute("tarefa") @Valid DataTask tarefa) {
        service.salvar(tarefa);
        return "redirect:/tarefas/html";
    }

    @GetMapping("/delete/{id}")
    public String deletarHtml(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/tarefas/html";
    }
}
