package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

/**
 * The {@code StudentService} class provides business logic operations for managing students.
 * It acts as an intermediary between the UI layer and the data access layer (repository).
 */
public class StudentService {
    private final StudentRepository studentRepository;

    /**
     * Constructs a new {@code StudentService} with the specified repository.
     *
     * @param studentRepository the repository used for student data persistence
     */
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Adds a new student with an email address after validating the input data.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param email     the email address of the student
     * @param batch     the batch the student belongs to
     */
    public void addStudent(String firstName, String lastName, String email, String batch) throws InvalidInputException {
        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Service error : Attempted to add student with invalid data");
            return;
        }
        studentRepository.addStudent(new Student(firstName, lastName, email, batch));
        throw new InvalidInputException("Email is not in valid format");

    }

    /**
     * Adds a new student without an email address after validating the input data.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param batch     the batch the student belongs to
     */
    public void addStudent(String firstName, String lastName, String batch) {
        Student newStudent = new Student(firstName, lastName, batch);
        studentRepository.addStudent(newStudent);
    }

    /**
     * Retrieves and prints all students from the repository.
     */
    public void displayAllStudents() {
        List<Student> studentList =studentRepository.displayAllStudents();
        for(Student st: studentList)
        {
            System.out.println(st);
        }
    }

    /**
     * Finds and prints a student's details by their ID.
     *
     * @param id the ID of the student to find
     * @throws EntityNotFoundException if no student with the given ID exists
     */
    public void findStudentById(int id) throws EntityNotFoundException {
        Student s= studentRepository.findById(id);
        System.out.println(s);

    }

    /**
     * Deactivates a student record by their ID.
     *
     * @param id the ID of the student to deactivate
     * @throws EntityNotFoundException if no student with the given ID exists
     */
    public void deActivateStudentById(int id) throws EntityNotFoundException {
        studentRepository.removeStudent(id);
    }

    /**
     * Deactivates a student record by their first and last name.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @throws EntityNotFoundException if no student matching the name exists
     */
    public void deActivateStudentByName(String firstName, String lastName) throws EntityNotFoundException {
        studentRepository.removeStudent(firstName, lastName);
    }
}


