package dev.Zerphyis.toDoList.Repositorys;

import dev.Zerphyis.toDoList.Entitys.Status;
import dev.Zerphyis.toDoList.Entitys.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,Long> {
    List<Tasks> findByStatus(Status status);
    List<Tasks> findByDeadLineBeforeAndStatusNot(LocalDate data, Status status);
}
