package com.example.assignmentone;

import org.json.JSONObject;

import java.util.Date;

public class Task {
    private String title;
    private Date dueDate;
    private String description;
    private boolean isCompleted;

    // Constructors
    public Task() {
        // Default constructor
    }

    public Task(String title, Date dueDate, String description, boolean isCompleted) {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public static Task fromJson(JSONObject jsonObject) {
        return null;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
