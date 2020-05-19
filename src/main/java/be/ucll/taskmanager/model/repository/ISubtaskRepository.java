package be.ucll.taskmanager.model.repository;

import be.ucll.taskmanager.model.domain.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubtaskRepository extends JpaRepository<Subtask, Integer> {}
