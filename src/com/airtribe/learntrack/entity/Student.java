package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

/**
 * Represents a student entity in the LearnTrack system.
 * A student extends the {@link Person} class and includes batch details and an active status.
 */
public class Student extends Person {

    /**
     * Constructs a new {@code Student} with an email address.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param email     the email address of the student
     * @param batch     the batch to which the student belongs
     */
    public Student(String firstName, String lastName, String email, String batch) {
        super(IdGenerator.getNextStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }
    /**
     * Constructs a new {@code Student} without an email address.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param batch     the batch to which the student belongs
     */
    public Student(String firstName,String lastName,String batch)
    {
        super(IdGenerator.getNextStudentId(),firstName,lastName);
        this.batch=batch;
        this.active=true;
    }
    private String batch;
    private boolean active;

    /**
     * Gets the student's batch.
     *
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * Sets the student's batch.
     *
     * @param batch the new batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * Checks if the student is active.
     *
     * @return {@code true} if the student is active, {@code false} otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active status of the student.
     *
     * @param active the new active status
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    /**
     * Retrieves the formatted display name of the student, including batch info.
     *
     * @return the formatted display name string
     */
    @Override
    public String getDisplayName() {
        return
                "Name: " +super.getDisplayName() + " | Batch: " + batch;
    }

    /**
     * Returns a string representation of the student, including ID, name, batch, and status.
     *
     * @return a formatted string representing the student
     */
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
