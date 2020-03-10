package be.ucll.taskmanager.service;

import be.ucll.taskmanager.domain.Subtask;
import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.SubtaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.repository.SubtaskRepository;
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
    private final SubtaskRepository subtaskRepository;

    private AtomicInteger ids;


    @Autowired
    public TaskService(TaskRepository repository, SubtaskRepository subtaskRepository)
    {
        this.repository = repository;
        this.subtaskRepository = subtaskRepository;

        this.ids = new AtomicInteger();
    }


    @Override
    public List<Task> getAllTasks()
    {
        return repository.findAll();
    }

    @Override
    public void addTask(TaskDTO taskdto)
    {
        Task task = new Task(ids.getAndIncrement(), taskdto.getTitle(), taskdto.getDetails(), taskdto.getDueDateTime());

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
