package dev.Zerphyis.toDoList.Execeptions;

public class TaskNotFoundExeception extends RuntimeException {
    public TaskNotFoundExeception(String message) {
        super(message);
    }
}
