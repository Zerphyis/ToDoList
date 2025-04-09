package dev.Zerphyis.toDoList.Service;

import dev.Zerphyis.toDoList.Entitys.Status;
import dev.Zerphyis.toDoList.Entitys.Tasks;
import dev.Zerphyis.toDoList.Execeptions.TaskNotFoundExeception;
import dev.Zerphyis.toDoList.Records.DataTask;
import dev.Zerphyis.toDoList.Repositorys.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TasksService {
    @Autowired
    TasksRepository repository;


    public List<Tasks> listarTodas() {
        return repository.findAll();
    }

    public Tasks salvar(DataTask data) {
        Tasks task = new Tasks(data);
        return repository.save(task);
    }

    public Tasks atualizar(Long id, DataTask data) {
        Tasks task = buscarPorId(id); // Já trata erro se não encontrar
        task.setName(data.name());
        task.setDescription(data.description());
        task.setDeadLine(data.deadLine());
        task.setStatus(data.status());
        return repository.save(task);
    }

    public Tasks buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundExeception("Tarefa não encontrada"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Tasks> listarPorStatus(Status status) {
        return repository.findByStatus(status);
    }

    public List<Tasks> listarAtrasadas() {
        return repository.findByDeadLineBeforeAndStatusNot(LocalDate.now(), Status.CONCLUIDA);
    }
}
