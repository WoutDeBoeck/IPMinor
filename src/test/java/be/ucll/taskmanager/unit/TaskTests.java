package be.ucll.taskmanager.unit;

import be.ucll.taskmanager.model.domain.Subtask;
import be.ucll.taskmanager.model.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class TaskTests
{
    private Task task;

    private int id = 1;
    private String title = "Test Title";
    private String details = "Test Details";

    private LocalDateTime now = LocalDateTime.now();
    private LocalDateTime dateTime = LocalDateTime.of(now.getYear() + 1, now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute());


    @BeforeEach
    public void initialize()
    {
        task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setDetails(details);
        task.setDueDateTime(dateTime);
    }

    @Test
    public void taskTakesAndReturnsCorrectId()
    {
        assertEquals(task.getId(), id);
    }

    @Test
    public void taskTakesAndReturnsCorrectTitle()
    {
        assertEquals(task.getTitle(), title);
    }

    @Test
    public void taskTakesAndReturnsCorrectDetails()
    {
        assertEquals(task.getDetails(), details);
    }

    @Test
    public void taskTakesAndReturnsCorrectDueDateTime()
    {
        assertEquals(task.getDueDateTime(), dateTime);
    }

    @Test
    public void passedDateGivesException()
    {
        assertThrows(IllegalArgumentException.class, () -> task.setDueDateTime(now.minusYears(1)));
    }

    @Test
    public void subtaskCanBeAdded()
    {
        task.addSubtask(new Subtask());
        assertTrue(task.hasSubtasks());
    }
}
