package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person {

    public Student(String firstName, String lastName, String email, String batch) {
        super(IdGenerator.getNextStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }
    public Student(String firstName,String lastName,String batch)
    {
        super(IdGenerator.getNextStudentId(),firstName,lastName);
        this.batch=batch;
        this.active=true;
    }
    private String batch;
    private boolean active;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String getDisplayName() {
        return
                "Name: " +super.getDisplayName() + " | Batch: " + batch;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %-4d | %s | Status: %s",
                getId(),
                getDisplayName(),
                (active ? "ACTIVE" : "DEACTIVATED")
        );
    }
}
