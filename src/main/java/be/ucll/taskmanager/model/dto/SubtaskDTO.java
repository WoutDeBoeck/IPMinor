package be.ucll.taskmanager.model.dto;

import javax.validation.constraints.NotEmpty;

public class SubtaskDTO
{
    @NotEmpty
    private String title;
    @NotEmpty
    private String details;


    public SubtaskDTO() {}


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
}
