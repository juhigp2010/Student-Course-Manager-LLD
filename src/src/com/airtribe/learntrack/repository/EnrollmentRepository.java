package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    public void enrollAStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> findByStudentId(int studentId) throws EntityNotFoundException {
        List<Enrollment> filteredList = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                filteredList.add(e);
            }
        }
        if (filteredList.isEmpty()) {
            throw new EntityNotFoundException("No enrollments found for Student ID: " + studentId);
        }
        return filteredList;
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus newStatus) throws EntityNotFoundException {
        Enrollment enrollment = findById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment record with ID " + enrollmentId + " does not exist.");
        }
        enrollment.setStatus(newStatus);
    }

    public Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment record with ID " + id + " not found.");
    }


}
