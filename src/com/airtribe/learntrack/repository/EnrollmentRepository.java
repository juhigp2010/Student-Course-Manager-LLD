package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code EnrollmentRepository} manages the in-memory storage of {@link Enrollment} entities.
 */
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();

    /**
     * Adds a new enrollment record to the repository.
     *
     * @param enrollment the enrollment to add
     */
    public void enrollAStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    /**
     * Retrieves all enrollments associated with a specific student ID.
     *
     * @param studentId the ID of the student
     * @return a list of {@link Enrollment} objects for the student
     * @throws EntityNotFoundException if no enrollments are found for the student
     */
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

    /**
     * Updates the status of a specific enrollment record.
     *
     * @param enrollmentId the ID of the enrollment to update
     * @param newStatus    the new {@link EnrollmentStatus} to apply
     * @throws EntityNotFoundException if the enrollment is not found
     */
    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus newStatus) throws EntityNotFoundException {
        Enrollment enrollment = findById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment record with ID " + enrollmentId + " does not exist.");
        }
        enrollment.setStatus(newStatus);
    }

    /**
     * Finds an enrollment by its unique ID.
     *
     * @param id the ID of the enrollment
     * @return the {@link Enrollment} matching the given ID
     * @throws EntityNotFoundException if the enrollment is not found
     */
    public Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new EntityNotFoundException("Enrollment record with ID " + id + " not found.");
    }


}
