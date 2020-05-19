package be.ucll.taskmanager.model.repository;

import be.ucll.taskmanager.model.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Integer>
{}
