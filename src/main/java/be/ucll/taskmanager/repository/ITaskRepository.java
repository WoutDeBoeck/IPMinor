package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Integer>
{}
