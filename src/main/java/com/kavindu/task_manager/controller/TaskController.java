package com.kavindu.task_manager.controller;

import com.kavindu.task_manager.model.Task;
import com.kavindu.task_manager.service.TaskService;
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
    public String createTask(@RequestBody Task task) {
        taskService.addTask(task);
        return "Task Added Successfully!";
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTaskById(id);
    }
}
