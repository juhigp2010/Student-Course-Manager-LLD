package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentRepository {

    private final List<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public List<Student> displayAllStudents() {
        return studentList;
    }

    public Student findById(int id) throws EntityNotFoundException {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        throw new EntityNotFoundException("Could not find a student with ID: " + id);
    }

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
