package be.ucll.taskmanager.domain;

import javax.validation.constraints.NotEmpty;

public class Subtask
{
    @NotEmpty
    private String title;
    @NotEmpty
    private String details;

    public Subtask(){}

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
}
