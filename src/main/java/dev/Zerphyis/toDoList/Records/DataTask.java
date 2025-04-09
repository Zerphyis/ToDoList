package dev.Zerphyis.toDoList.Records;

import dev.Zerphyis.toDoList.Entitys.Status;

import java.time.LocalDate;

public record DataTask(String name, String description, LocalDate deadLine, Status status) {
}
