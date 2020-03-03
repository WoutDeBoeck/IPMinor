package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.Subtask;
import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.TaskDTO;

import java.util.List;

public interface ITaskService
{
    List<Task> getAllTasks();
    void addTask(TaskDTO task);
    Task getTaskById(int id);
    void editTaskWithId(int id, TaskDTO updatedTask);

    void addSubtaskToTaskWithId(int id, Subtask subtask);
}
