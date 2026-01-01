package com.kavindu.task_manager.controller;

import com.kavindu.task_manager.dto.TaskDTO;
import com.kavindu.task_manager.model.Task;
import com.kavindu.task_manager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public String createTask(@Valid @RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
        return "Task Added Successfully!";
    }

    @GetMapping
    public List<TaskDTO> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable int id, @Valid @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(id,taskDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "Task deleted successfully!";
    }
}
