package com.kavindu.task_manager.service;

import com.kavindu.task_manager.dto.TaskDTO;

import com.kavindu.task_manager.model.Task;
import com.kavindu.task_manager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock // 1. අලුතින් එකතු කළා: TaskMapper එකත් Mock කරන්න ඕන
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testCreateTask() {
        // --- ARRANGE ---
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("DTO Test Task");
        taskDTO.setDescription("Testing with DTO");

        Task mockedEntity = new Task();
        mockedEntity.setId(1);
        mockedEntity.setTitle("DTO Test Task");
        mockedEntity.setDescription("Testing with DTO");

        // 2. Mapper එකට උගන්වන්න ඕන DTO එකක් ආවම Entity එකක් දෙන්න කියලා
        when(taskMapper.toEntity(any(TaskDTO.class))).thenReturn(mockedEntity);

        // 3. Repository එකට උගන්වන්න ඕන save කළාම Entity එක ආපහු දෙන්න කියලා
        when(taskRepository.save(any(Task.class))).thenReturn(mockedEntity);

        // 4. අන්තිමට Service එකෙන් එළියට යවද්දි Entity එක ආයේ DTO කරන්න ඕනනේ. ඒකත් Mock කරනවා.
        when(taskMapper.toDTO(any(Task.class))).thenReturn(taskDTO);

        // --- ACT ---
        // මෙතන ඔයාගේ method name එක 'addTask' නම් ඒක දාන්න (Stack trace එකේ තිබ්බේ addTask කියලා)
        TaskDTO savedDto = taskService.addTask(taskDTO);

        // --- ASSERT ---
        assertNotNull(savedDto);
        assertEquals("DTO Test Task", savedDto.getTitle());

        // Verify calls
        verify(taskRepository).save(any(Task.class));
        verify(taskMapper).toEntity(any(TaskDTO.class)); // Mapper එක call වුනාද කියලත් බලනවා
    }
}