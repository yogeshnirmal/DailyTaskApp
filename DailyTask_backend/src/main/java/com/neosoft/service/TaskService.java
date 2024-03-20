package com.neosoft.service;

import com.neosoft.model.Task;

import java.util.List;

public interface TaskService {
    public Task addTask(Task task);
    public Task updateTask(Task task);
    public Task getTaskById(Long id);
    public void deleteTask(Long id);
    public List<Task> allTask();
}
