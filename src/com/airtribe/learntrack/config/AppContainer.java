package com.airtribe.learntrack.config;

import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.ui.CourseUI;
import com.airtribe.learntrack.ui.EnrollmentUI;
import com.airtribe.learntrack.ui.StudentUI;

import java.util.Scanner;

/**
 * The {@code AppContainer} acts as a rudimentary dependency injection container.
 * It instantiates and wires together the repositories, services, and UI components
 * required for the application.
 */
public class AppContainer {
    private final StudentUI studentUI;
    private final CourseUI courseUI;
    private final EnrollmentUI enrollmentUI;

    /**
     * Constructs an {@code AppContainer} and initializes all application dependencies.
     *
     * @param scanner the shared {@link Scanner} instance for user input
     */
    public AppContainer(Scanner scanner) {
        // 1. Initialize Repositories
        StudentRepository studentRepo = new StudentRepository();
        CourseRepository courseRepo = new CourseRepository();
        EnrollmentRepository enrollmentRepo = new EnrollmentRepository();

        // 2. Initialize Services
        StudentService studentService = new StudentService(studentRepo);
        CourseService courseService = new CourseService(courseRepo);
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepo, studentRepo, courseRepo);

        // 3. Initialize UI Handlers
        this.studentUI = new StudentUI(scanner, studentService);
        this.courseUI = new CourseUI(scanner, courseService);
        this.enrollmentUI = new EnrollmentUI(scanner, enrollmentService);
    }

    // Getters for the UI classes
    /**
     * Gets the {@link StudentUI} instance.
     *
     * @return the configured student UI handler
     */
    public StudentUI getStudentUI() {
        return studentUI;
    }

    /**
     * Gets the {@link CourseUI} instance.
     *
     * @return the configured course UI handler
     */
    public CourseUI getCourseUI() {
        return courseUI;
    }

    /**
     * Gets the {@link EnrollmentUI} instance.
     *
     * @return the configured enrollment UI handler
     */
    public EnrollmentUI getEnrollmentUI() {
        return enrollmentUI;
    }
}
