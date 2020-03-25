package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.Subtask;
import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.SubtaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.repository.ISubtaskRepository;
import be.ucll.taskmanager.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService
{
    private final ITaskRepository repository;
    private final ISubtaskRepository subtaskRepository;


    @Autowired
    public TaskService(ITaskRepository repository, ISubtaskRepository subtaskRepository)
    {
        this.repository = repository;
        this.subtaskRepository = subtaskRepository;
    }


    @Override
    public List<Task> getAllTasks()
    {
        return repository.findAll();
    }

    @Override
    public void addTask(TaskDTO taskdto)
    {
        Task task = new Task();

        task.setTitle(taskdto.getTitle());
        task.setDetails(taskdto.getDetails());
        task.setDueDateTime(taskdto.getDueDateTime());

        repository.save(task);
    }

    @Override
    public Task getTaskById(int id)
    {
        List<Task> tasks = getAllTasks();
        Task output = null;

        for (Task task : tasks)
        {
            if(task.getId() == id)
            {
                output = task;
            }
        }

        return output;
    }

    @Override
    public void editTaskWithId(int id, TaskDTO updatedTask)
    {
        Task task = getTaskById(id);

        if(task != null)
        {
            task.setTitle(updatedTask.getTitle());
            task.setDetails(updatedTask.getDetails());
            task.setDueDateTime(updatedTask.getDueDateTime());
        }

        repository.save(task);
    }

    @Override
    public void addSubtaskToTaskWithId(int id, SubtaskDTO subtaskDTO)
    {
        Task task = getTaskById(id);

        if(task != null)
        {
            Subtask subtask = new Subtask();

            subtask.setTitle(subtaskDTO.getTitle());
            subtask.setDetails(subtaskDTO.getDetails());

            subtaskRepository.save(subtask);

            task.addSubtask(subtask);
        }

        repository.save(task);
    }
}
