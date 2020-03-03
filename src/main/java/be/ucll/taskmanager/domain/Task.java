package be.ucll.taskmanager.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Task
{
    private int id;
    private String title;
    private String details;
    private LocalDateTime dueDateTime;

    private List<Subtask> subtasks;


    public Task(int id, String title, String details, LocalDateTime dueDateTime)
    {
        setId(id);
        setTitle(title);
        setDueDateTime(dueDateTime);
        setDetails(details);

        subtasks = new ArrayList<>();
    }

    public Task(int id, String title, String details, LocalDate dueDate, LocalTime dueTime)
    {
        setId(id);
        setTitle(title);
        setDueDateTime(LocalDateTime.of(dueDate, dueTime));
        setDetails(details);

        subtasks = new ArrayList<>();
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public LocalDateTime getDueDateTime()
    {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime)
    {
        LocalDateTime now = LocalDateTime.now();

        if(now.isAfter(dueDateTime))
        {
            throw new IllegalArgumentException("The due date should be in the future.");
        }

        this.dueDateTime = dueDateTime;
    }


    public void addSubtask(Subtask subtask)
    {
        subtasks.add(subtask);
    }

    public List<Subtask> getSubtasks()
    {
        return subtasks;
    }

    public boolean hasSubtasks()
    {
        return !subtasks.isEmpty();
    }
}
