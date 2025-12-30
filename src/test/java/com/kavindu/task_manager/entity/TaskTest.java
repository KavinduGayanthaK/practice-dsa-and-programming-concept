package com.kavindu.task_manager.entity;

import com.kavindu.task_manager.model.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {

    @Test
    void testTaskCreation() {
        // 1. Arrange (සූදානම් වීම)
        Task task = new Task();
        task.setTitle("Learn Unit Testing");
        task.setDescription("Start with JUnit");
        task.setCompleted(false);

        // 2. Act (මෙතනදි නම් විශේෂ දෙයක් වෙන්නේ නෑ, Getters ටික call කරන එක තමයි වෙන්නේ)
        String title = task.getTitle();

        // 3. Assert (තහවුරු කිරීම)
        // assertEquals(බලාපොරොත්තු වන අගය, ඇත්තටම ලැබුනු අගය);
        assertEquals("Learn Unit Testing", title, "Task title should match");
        assertFalse(task.isCompleted(), "New task should not completed");

    }
}
