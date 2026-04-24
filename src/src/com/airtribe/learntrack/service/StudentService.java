package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(String firstName, String lastName, String email, String batch) {
        if (!InputValidator.isValidName(firstName) || !InputValidator.isValidName(lastName)
                || !InputValidator.isValidEmail(email)) {
            System.out.println("Service error : Attempted to add student with invalid data");
            return;
        }
        Student newStudent = new Student(firstName, lastName, email, batch);
        studentRepository.addStudent(newStudent);

    }

    public void addStudent(String firstName, String lastName, String batch) {
        if (!InputValidator.isValidName(firstName) || !InputValidator.isValidName(lastName)) {
            System.out.println("Service error : Attempted to add student with invalid data");
            return;
        }
        Student newStudent = new Student(firstName, lastName, batch);
        studentRepository.addStudent(newStudent);
    }

    public void displayAllStudents() {
        List<Student> studentList =studentRepository.displayAllStudents();
        for(Student st: studentList)
        {
            System.out.println(st);
        }
    }

    public void findStudentById(int id) throws EntityNotFoundException {
        Student s= studentRepository.findById(id);
        if (s == null) {
            throw new EntityNotFoundException("Student with ID " + id + " not found.");
        }
        System.out.println(s);

    }

    public void deActivateStudentById(int id) throws EntityNotFoundException {
        studentRepository.removeStudent(id);
    }

    public void deActivateStudentByName(String firstName, String lastName) throws EntityNotFoundException {
        studentRepository.removeStudent(firstName, lastName);
    }
}


