package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.domain.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {}
