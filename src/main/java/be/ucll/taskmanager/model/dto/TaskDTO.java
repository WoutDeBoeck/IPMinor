package be.ucll.taskmanager.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class TaskDTO
{
    @NotEmpty
    private String title;
    @NotEmpty
    private String details;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDateTime;


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
        this.dueDateTime = dueDateTime;
    }
}
