package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;

/**
 * Represents an enrollment record connecting a student to a course.
 */
public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    /**
     * Gets the unique ID of the enrollment.
     *
     * @return the enrollment ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique ID of the enrollment.
     *
     * @param id the new enrollment ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the enrolled student.
     *
     * @return the student ID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the ID of the enrolled student.
     *
     * @param studentId the new student ID
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the ID of the course.
     *
     * @return the course ID
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * Sets the ID of the course.
     *
     * @param courseId the new course ID
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the date of enrollment.
     *
     * @return the enrollment date
     */
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * Sets the date of enrollment.
     *
     * @param enrollmentDate the new enrollment date
     */
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    /**
     * Gets the current status of the enrollment.
     *
     * @return the enrollment status
     */
    public EnrollmentStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the enrollment.
     *
     * @param status the new enrollment status
     */
    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    /**
     * Constructs a new {@code Enrollment} record.
     * The enrollment ID and date are generated automatically.
     *
     * @param studentId the ID of the student
     * @param courseId  the ID of the course
     * @param status    the initial status of the enrollment
     */
    public Enrollment(int studentId, int courseId, EnrollmentStatus status) {
        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now(); // Automatically set to today
        this.status = status;
    }

    /**
     * Returns a string representation of the enrollment record.
     *
     * @return a formatted string representing the enrollment
     */
    @Override
    public String toString() {
        return "Enrollment ID: " + id + " | Student ID: " + studentId +
                " | Course ID: " + courseId + " | Status: " + status +
                " | Date: " + enrollmentDate;
    }
}

