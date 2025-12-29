package com.kavindu.task_manager.service;

import com.kavindu.task_manager.exception.TaskNotFoundException;
import com.kavindu.task_manager.model.Task;
import com.kavindu.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor Injection (Best Practice)
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).
                orElseThrow(() -> new TaskNotFoundException("Task not found with id: "+id));
    }

    public Task updateTask(int id, Task taskDetails) {
        Task existingTask = getTaskById(id);

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setCompleted(taskDetails.isCompleted());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(int id) {
        Task existingTask = getTaskById(id);
        taskRepository.delete(existingTask);
    }
}
