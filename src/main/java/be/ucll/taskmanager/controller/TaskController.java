package be.ucll.taskmanager.controller;

import be.ucll.taskmanager.model.domain.Task;
import be.ucll.taskmanager.model.dto.SubtaskDTO;
import be.ucll.taskmanager.model.dto.TaskDTO;
import be.ucll.taskmanager.model.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class TaskController
{
    private final ITaskService service;

    @Autowired
    public TaskController(ITaskService service)
    {
        this.service = service;
    }

    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }

    //Get Tasks

    @GetMapping("tasks")
    public String getAllTasks(Model model)
    {
        model.addAttribute("tasks", service.getAllTasks());
        return "tasks";
    }

    @GetMapping("tasks/{taskId}")
    public String getTaskById(Model model, @PathVariable int taskId)
    {
        Task task = service.getTaskById(taskId);
        model.addAttribute("task", task);

        return "details";
    }

    //Task creation

    @GetMapping("tasks/new")
    public String getTaskCreationPage()
    {
        return "createTask";
    }

    @PostMapping("tasks/create")
    public String createNewTask(@ModelAttribute TaskDTO task)
    {
        service.addTask(task);
        return "redirect:/tasks";
    }

    //Edit task

    @GetMapping("/tasks/edit/{id}")
    public String getEditPageForTask(@PathVariable int id, Model model)
    {
        Task task = service.getTaskById(id);
        model.addAttribute("task", task);

        return "edit";
    }

    @PostMapping("/tasks/update/{id}")
    public String updateTaskWithId(@PathVariable int id, @ModelAttribute TaskDTO updatedTask)
    {
        service.editTaskWithId(id, updatedTask);
        return "redirect:/tasks/" + id;
    }

    //Subtask addition

    @GetMapping("/tasks/{id}/sub/create")
    public String getSubtaskCreationPageForTask(@PathVariable int id, Model model)
    {
        Task task = service.getTaskById(id);
        model.addAttribute("task", task);

        return "addSubtask";
    }

    @PostMapping("/tasks/{id}/sub/add")
    public String addSubtaskToTaskWithId(@PathVariable int id, @ModelAttribute SubtaskDTO subtaskDTO)
    {
        service.addSubtaskToTaskWithId(id, subtaskDTO);

        return "redirect:/tasks/" + id;
    }
}
