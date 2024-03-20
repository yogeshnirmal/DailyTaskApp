package com.neosoft.controller;

import com.neosoft.model.Task;
import com.neosoft.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/task")
@CrossOrigin("*")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/")
    private Task saveTask(@RequestBody Task task) {
              return taskService.addTask(task);
    }
    @GetMapping(value = "/{id}")
    private Task   getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @GetMapping(value = "/")
    private List<Task> getAllTask() {
        return taskService.allTask();
    }
    @DeleteMapping(value = "/{id}")
    private void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping(value="/{id}")
    private Task  updateHoliday(@PathVariable Long id,@RequestBody Task  task) {
        task.setId(id);
        return taskService.updateTask(task);
    }
}
