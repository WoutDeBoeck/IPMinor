package be.ucll.taskmanager.model.service;

import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.SubtaskDTO;
import be.ucll.taskmanager.model.dto.TaskDTO;

import java.util.List;

public interface ITaskService
{
    List<Task> getAllTasks();
    void addTask(TaskDTO task);
    Task getTaskById(int id);
    void editTaskWithId(int id, TaskDTO updatedTask);

    void addSubtaskToTaskWithId(int id, SubtaskDTO subtask);
}
