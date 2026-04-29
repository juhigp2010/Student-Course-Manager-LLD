package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.EnrollmentMenuOptions;
import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.EnrollmentService;

import java.util.Scanner;

/**
 * The {@code EnrollmentUI} class provides a console-based user interface for managing enrollments.
 * It interacts with the {@link EnrollmentService} to process user actions.
 */
public class EnrollmentUI {
    private final Scanner scanner;
    private final EnrollmentService enrollmentService;

    /**
     * Constructs an {@code EnrollmentUI} instance.
     *
     * @param scanner           the {@link Scanner} used to read user input from the console
     * @param enrollmentService the service used to handle enrollment business logic
     */
    public EnrollmentUI(Scanner scanner, EnrollmentService enrollmentService) {
        this.scanner = scanner;
        this.enrollmentService = enrollmentService;
    }

    /**
     * Displays and handles the enrollment management menu.
     * Continuously prompts the user for choices until they choose to exit.
     */
    public void handleEnrollmentMenu() {
        boolean backToMain = false;
        while (!backToMain) {
            showEnrollmentMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> enrollStudent();
                    case 2 -> viewStudentEnrollments();
                    case 3 -> updateEnrollmentStatus();
                    case 4 -> {
                        System.out.println("Returning to Main Menu...");
                        backToMain = true;
                    }
                    default -> System.out.println("Invalid Option. Please try again.");
                }
            } catch (EntityNotFoundException e) {
                // Using println to ensure the error message appears on its own line
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Prompts the user for student and course IDs to enroll a student in a course.
     *
     * @throws EntityNotFoundException if the student or course is not found
     */
    // Helper Method for Case 1
    private void enrollStudent() throws EntityNotFoundException {
        System.out.print("Enter Student ID: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Course ID: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        enrollmentService.enrollStudent(studentId, courseId);
        System.out.println("Student enrolled successfully!");
    }

    /**
     * Prompts the user for a student ID and displays all enrollments for that student.
     *
     * @throws EntityNotFoundException if the student is not found
     */
    // Helper Method for Case 2
    private void viewStudentEnrollments() throws EntityNotFoundException {
        System.out.print("Enter Student ID to view enrollments: ");
        int sId = Integer.parseInt(scanner.nextLine());
        enrollmentService.viewStudentEnrollments(sId);
    }

    /**
     * Prompts the user for an enrollment ID and new status, then updates the enrollment's status.
     *
     * @throws EntityNotFoundException if the enrollment is not found
     */
    // Helper Method for Case 3
    private void updateEnrollmentStatus() throws EntityNotFoundException {
        System.out.print("Enter Enrollment ID: ");
        int eId = Integer.parseInt(scanner.nextLine());

        System.out.println("Select New Status: ");
        System.out.println("1. COMPLETED");
        System.out.println("2. CANCELLED");
        System.out.print("Selection: ");

        int statusChoice = Integer.parseInt(scanner.nextLine());
        EnrollmentStatus newStatus = null;

        if (statusChoice == 1) {
            newStatus = EnrollmentStatus.COMPLETED;
        } else if (statusChoice == 2) {
            newStatus = EnrollmentStatus.CANCELLED;
        }

        if (newStatus != null) {
            enrollmentService.updateStatus(eId, newStatus);
            System.out.println("Enrollment status updated to " + newStatus);
        } else {
            System.out.println("Invalid status selection. Update cancelled.");
        }
    }

    /**
     * Displays the available enrollment menu options to the console.
     */
    private void showEnrollmentMenu() {
        System.out.println("\n=== Running Enrollment Service ===");
        System.out.println(EnrollmentMenuOptions.ENROLL_STUDENT);
        System.out.println(EnrollmentMenuOptions.DISPLAY_ENROLMENT_STUDENT);
        System.out.println(EnrollmentMenuOptions.UPDATE_ENROLLMENT_STATUS);
        System.out.println(EnrollmentMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }
}
