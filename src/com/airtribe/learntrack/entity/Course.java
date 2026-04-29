package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

/**
 * Represents a course entity in the LearnTrack system.
 */
public class Course {
    private int id;

    /**
     * Constructs a new {@code Course} with the specified details.
     * The course is automatically assigned a unique ID and marked as active.
     *
     * @param courseName      the name of the course
     * @param description     the description of the course
     * @param durationInWeeks the duration of the course in weeks
     */
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

    /**
     * Checks if the course is active.
     *
     * @return {@code true} if the course is active, {@code false} otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active status of the course.
     *
     * @param active the new active status
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    private boolean active;

    /**
     * Gets the unique ID of the course.
     *
     * @return the course ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique ID of the course.
     *
     * @param id the new course ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the course.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName the new course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets the description of the course.
     *
     * @return the course description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the course.
     *
     * @param description the new course description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the duration of the course in weeks.
     *
     * @return the course duration in weeks
     */
    public String getDurationInWeeks() {
        return durationInWeeks;
    }

    /**
     * Sets the duration of the course in weeks.
     *
     * @param durationInWeeks the new duration
     */
    public void setDurationInWeeks(String durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a formatted string representing the course
     */
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


