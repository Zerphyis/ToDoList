package dev.Zerphyis.toDoList.Entitys;

import dev.Zerphyis.toDoList.Records.DataTask;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "nome ê obrigatório")
    private String name;

    private String description;
    @NotNull(message = "Data límite ê obrigatória")
    private LocalDate deadLine;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tasks(){

    }

    public Tasks(DataTask data){
        this.name= data.name();
        this.description= data.description();
        this.deadLine=data.deadLine();
        this.status=data.status();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
