package be.ucll.taskmanager.unit;

import be.ucll.taskmanager.model.domain.Subtask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtaskTests
{
    private Subtask subtask;

    private int id = 1;
    private String title = "Test Title";
    private String details = "Test Details";


    @BeforeEach
    public void initialize()
    {
        subtask = new Subtask();

        subtask.setId(id);
        subtask.setTitle(title);
        subtask.setDetails(details);
    }

    @Test
    public void subtaskTakesAndReturnsCorrectId()
    {
        assertEquals(subtask.getId(), id);
    }

    @Test
    public void subtaskTakesAndReturnsCorrectTitle()
    {
        assertEquals(subtask.getTitle(), title);
    }

    @Test
    public void subtaskTakesAndReturnsCorrectDetails()
    {
        assertEquals(subtask.getDetails(), details);
    }
}
