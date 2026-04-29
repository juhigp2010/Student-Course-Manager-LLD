package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public Enrollment(int studentId, int courseId, EnrollmentStatus status) {
        this.id = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now(); // Automatically set to today
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment ID: " + id + " | Student ID: " + studentId +
                " | Course ID: " + courseId + " | Status: " + status +
                " | Date: " + enrollmentDate;
    }
}

