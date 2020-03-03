package be.ucll.taskmanager.repository;

import be.ucll.taskmanager.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository
{
    private List<Task> tasks;


    public TaskRepository()
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
