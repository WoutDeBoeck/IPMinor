package be.ucll.taskmanager.integration;

import be.ucll.taskmanager.domain.Task;
import be.ucll.taskmanager.dto.SubtaskDTO;
import be.ucll.taskmanager.dto.TaskDTO;
import be.ucll.taskmanager.service.TaskService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTests
{
    @Autowired
    private TaskService service;

    private static TaskDTO taskDTO = new TaskDTO();


    @BeforeAll
    public static void initialize()
    {
        taskDTO.setTitle("Test Title");
        taskDTO.setDetails("Test Details");
        taskDTO.setDueDateTime(LocalDateTime.now().plusYears(1));
    }

    @Test
    public void serviceIsCreatedProperly()
    {
        assertNotNull(service);
    }

    @Test
    public void taskCanBeAdded()
    {
        int size = service.getAllTasks().size();

        service.addTask(taskDTO);
        assertEquals(service.getAllTasks().size(), size + 1);
    }

    @Test
    public void taskCanBeFoundById()
    {
        service.addTask(taskDTO);
        Task task = service.getTaskById(1);

        assertNotNull(task);
        assertEquals(task.getTitle(), taskDTO.getTitle());
    }

    //TODO: find fix for LazyInitializationException
    @Disabled
    @Test
    public void subtaskCanBeAddedToExistingTask()
    {
        service.addTask(taskDTO);

        SubtaskDTO subtaskDTO = new SubtaskDTO();

        subtaskDTO.setTitle("Test Title");
        subtaskDTO.setDetails("Test Details");

        service.addSubtaskToTaskWithId(1, subtaskDTO);

        Task task = service.getTaskById(1);
        assertTrue(task.hasSubtasks());
    }

    @Test
    public void taskCanBeUpdated()
    {
        service.addTask(taskDTO);

        TaskDTO update = taskDTO;
        update.setDueDateTime(taskDTO.getDueDateTime().plusYears(1));

        service.editTaskWithId(1, update);

        assertEquals(service.getTaskById(1).getDueDateTime(), update.getDueDateTime());
    }
}
