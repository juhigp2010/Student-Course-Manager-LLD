package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Course {
    private int id;

    public Course(String courseName, String description, String durationInWeeks) {
        this.id = IdGenerator.getNextCourseId();
        this.active = true;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;

    }

    private String courseName;
    private String description;
    private String durationInWeeks;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(String durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-15s |Description: %s | Duration: %s Weeks | Status: %s",
                id,
                courseName,
                description,
                durationInWeeks,
                (active ? "ACTIVE" : "INACTIVE")
        );
    }
}


