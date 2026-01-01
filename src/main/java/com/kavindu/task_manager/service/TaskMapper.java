package com.kavindu.task_manager.service;
import com.kavindu.task_manager.dto.TaskDTO;
import com.kavindu.task_manager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId()); // Update කරන වෙලාවට ID එක ඕන වෙනවා
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return task;
    }

    public TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        return dto;
    }
}
