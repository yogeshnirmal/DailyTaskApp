package com.neosoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String employeeName;
    private String taskName;
    private Date taskStartDate;
    private int numberofDays;
    private Date taskEndDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(Date taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public int getNumberofDays() {
        return numberofDays;
    }

    public void setNumberofDays(int numberofDays) {
        this.numberofDays = numberofDays;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public Task() {
    }

    public Task(long id, String employeeName, String taskName, Date taskStartDate, int numberofDays, Date taskEndDate) {
        this.id = id;
        this.employeeName = employeeName;
        this.taskName = taskName;
        this.taskStartDate = taskStartDate;
        this.numberofDays = numberofDays;
        this.taskEndDate = taskEndDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskStartDate=" + taskStartDate +
                ", numberofDays=" + numberofDays +
                ", taskEndDate=" + taskEndDate +
                '}';
    }
}
