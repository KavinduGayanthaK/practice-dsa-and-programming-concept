package com.kavindu.task_manager.service;

import com.kavindu.task_manager.dto.TaskDTO;
import com.kavindu.task_manager.exception.TaskNotFoundException;
import com.kavindu.task_manager.model.Task;
import com.kavindu.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    // Constructor Injection (Best Practice)
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDTO addTask(TaskDTO taskDTO) {
       Task task = taskMapper.toEntity(taskDTO);
       Task savedTask = taskRepository.save(task);
       return taskMapper.toDTO(savedTask);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> task = taskRepository.findAll();
        return task.stream()
                .map(taskMapper::toDTO)
                .toList();

    }

    public TaskDTO getTaskById(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        return taskMapper.toDTO(task);
    }

    public TaskDTO updateTask(int id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(taskDTO.getTitle());
        existingTask.setDescription(taskDTO.getDescription());
        existingTask.setCompleted(taskDTO.isCompleted());

        Task savedTask = taskRepository.save(existingTask);
        return taskMapper.toDTO(savedTask);
    }

    public void deleteTask(int id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }
}
