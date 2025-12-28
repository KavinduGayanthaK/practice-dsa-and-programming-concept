package com.kavindu.task_manager.service;

import com.kavindu.task_manager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public List<Task> getAllTask() {
        return taskList;
    }

    public Task getTaskById(int id) {
        for (Task task: taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
