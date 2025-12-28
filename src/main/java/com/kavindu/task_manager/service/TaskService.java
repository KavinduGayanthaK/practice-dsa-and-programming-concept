package com.kavindu.task_manager.service;

import com.kavindu.task_manager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    //private final List<Task> taskList = new ArrayList<>();
    // We are get arraylist alternative hashmap
    //key = TaskID(Integer)
    //value = Task Object
    private Map<Integer,Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        taskMap.put(task.getId(),task);
    }

    public List<Task> getAllTask() {
        return new ArrayList<>(taskMap.values());
    }

    public Task getTaskById(int id) {
//        for (Task task: taskList) {
//            if (task.getId() == id) {
//                return task;
//            }
//        }
//        return null;

        return taskMap.get(id);
    }
}
