package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The {@code StudentRepository} class manages the persistence of {@link Student} entities
 * using an in-memory list.
 */
public class StudentRepository {

    private final List<Student> studentList = new ArrayList<>();

    /**
     * Adds a new {@link Student} to the repository.
     *
     * @param s the student to add
     */
    public void addStudent(Student s) {
        studentList.add(s);
    }

    /**
     * Retrieves a list of all students currently in the repository.
     *
     * @return a list of {@link Student} objects
     */
    public List<Student> displayAllStudents() {
        return studentList;
    }

    /**
     * Finds a student by their unique ID.
     *
     * @param id the ID of the student to find
     * @return the {@link Student} matching the given ID
     * @throws EntityNotFoundException if the student is not found
     */
    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Could not find a student with ID: " + id);
    }

    /**
     * Deactivates a student based on their first and last name.
     * Note: This method sets the student's active status to false instead of removing them from the list.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @throws EntityNotFoundException if the student is not found
     */
    public void removeStudent(String firstName, String lastName) throws EntityNotFoundException {
        for (Student s : studentList) {
            if (Objects.equals(s.getFirstName(), firstName) && Objects.equals(s.getLastName(), lastName)) {
                s.setActive(false);
                System.out.println("Student with given name" + s.getDisplayName() + " has been deactivated.");
                return;
            }
        }
        throw new EntityNotFoundException("Could not find the student with given Name");
    }

    /**
     * Deactivates a student based on their unique ID.
     * Note: This method sets the student's active status to false instead of removing them from the list.
     *
     * @param id the ID of the student
     * @throws EntityNotFoundException if the student is not found
     */
    public void removeStudent(int id) throws EntityNotFoundException {
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.setActive(false);
                System.out.println("Student ID" + id + " has been deactivated.");
                return;
            }
            throw new EntityNotFoundException("Could not find a student with ID: " + id);
        }
    }
}
