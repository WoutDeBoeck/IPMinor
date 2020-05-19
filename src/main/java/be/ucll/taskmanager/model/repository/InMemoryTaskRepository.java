package be.ucll.taskmanager.model.repository;

import be.ucll.taskmanager.model.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTaskRepository
{
    private List<Task> tasks;


    public InMemoryTaskRepository()
    {
        tasks = new ArrayList<>();
    }


    public List<Task> getTasks()
    {
        return tasks;
    }

    public void addTask(Task task)
    {
        tasks.add(task);
    }

}
