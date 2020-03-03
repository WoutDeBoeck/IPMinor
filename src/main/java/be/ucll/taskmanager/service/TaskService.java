package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.Subtask;
import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskService implements ITaskService
{
    private final TaskRepository repository;
    private AtomicInteger ids;


    @Autowired
    public TaskService(TaskRepository repository)
    {
        this.repository = repository;
        this.ids = new AtomicInteger();

        //TODO: Delete dummy data creation
        TaskDTO ipMinor = new TaskDTO();
        ipMinor.setDueDateTime(LocalDateTime.of(2020, 7, 1, 0, 0));
        ipMinor.setTitle("Pass for IP Minor");
        ipMinor.setDetails("Create a project that nets me a decent score");
        addTask(ipMinor);
    }


    @Override
    public List<Task> getAllTasks()
    {
        return repository.getTasks();
    }

    @Override
    public void addTask(TaskDTO taskdto)
    {
        Task task = new Task(ids.getAndIncrement(), taskdto.getTitle(), taskdto.getDetails(), taskdto.getDueDateTime());

        repository.addTask(task);
    }

    @Override
    public Task getTaskById(int id)
    {
        List<Task> tasks = repository.getTasks();
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
    }

    @Override
    public void addSubtaskToTaskWithId(int id, Subtask subtask)
    {
        Task task = getTaskById(id);

        if(task != null)
        {
            task.addSubtask(subtask);
        }
    }
}
