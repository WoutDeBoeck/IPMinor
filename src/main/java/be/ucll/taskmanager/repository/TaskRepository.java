package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>
{}
