package com.airtribe.learntrack.ui;
import com.airtribe.learntrack.constants.StudentMenuOptions;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

/**
 * The {@code StudentUI} class handles the console-based user interface for student management.
 * It interacts with the {@link StudentService} to perform operations based on user input.
 */
public class StudentUI {
    private final Scanner scanner;
    private final StudentService studentService;

    /**
     * Constructs a {@code StudentUI} instance.
     *
     * @param scanner        the {@link Scanner} used to read user input from the console
     * @param studentService the service used to handle student-related business logic
     */
    public StudentUI(Scanner scanner, StudentService studentService) {
        this.scanner = scanner;
        this.studentService = studentService;
    }

    /**
     * Displays and handles the student management menu.
     * Continuously prompts the user for a selection until they choose to return to the main menu.
     */
    public void handleStudentMenu() {
        boolean backToMain = false;
        while (!backToMain) {
            showStudentMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addNewStudent();
                    case 2 -> studentService.displayAllStudents();
                    case 3 -> findStudent();
                    case 4 -> handleDeactivation();
                    case 5 -> {
                        System.out.println("Closing the Student service.");
                        backToMain = true;
                    }
                    default -> System.out.println("Invalid Option");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (EntityNotFoundException e) {
                System.out.println("Could not found Student with given data");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Prompts the user for student details and creates a new student record.
     */
    // Helper for Case 1
    private void addNewStudent() throws InvalidInputException {
        System.out.print("Please enter first Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Please enter lastName: ");
        String lastName = scanner.nextLine();
        System.out.print("Please enter batch: ");
        String batch = scanner.nextLine();

        System.out.print("Do you want to provide an email? (y/n): ");
        String emailChoice = scanner.nextLine().trim().toLowerCase();

        if (emailChoice.equals("y")) {
            System.out.print("Please enter email: ");
            String email = scanner.nextLine();
            studentService.addStudent(firstName, lastName, email, batch);
        } else {
            studentService.addStudent(firstName, lastName, batch);
        }
        System.out.println("Student created successfully..!!");
    }

    /**
     * Prompts the user for a student ID and searches for the student.
     *
     * @throws EntityNotFoundException if the student is not found
     */
    // Helper for Case 3
    private void findStudent() throws EntityNotFoundException {
        System.out.print("Please enter the student id you want to search: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        studentService.findStudentById(studentId);
    }

    /**
     * Prompts the user to select the method of deactivation (by ID or by name)
     * and delegates to the appropriate method.
     *
     * @throws EntityNotFoundException if the student to deactivate is not found
     */
    // Helper for Case 4 (Logic breakdown)
    private void handleDeactivation() throws EntityNotFoundException {
        System.out.print("Deactivate student by: 1. ID | 2. Name: ");
        int deactivationChoice = Integer.parseInt(scanner.nextLine());

        switch (deactivationChoice) {
            case 1 -> deactivateById();
            case 2 -> deactivateByName();
            default -> System.out.println("Invalid selection.");
        }
    }

    /**
     * Prompts the user for a student ID and deactivates the corresponding student.
     *
     * @throws EntityNotFoundException if the student is not found
     */
    private void deactivateById() throws EntityNotFoundException {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentService.deActivateStudentById(id);
        System.out.println("Student deactivated successfully.");
    }

    /**
     * Prompts the user for a student's first and last name and deactivates the corresponding student.
     *
     * @throws EntityNotFoundException if the student is not found
     */
    private void deactivateByName() throws EntityNotFoundException {
        System.out.print("First Name: ");
        String fn = scanner.nextLine();
        System.out.print("Last Name: ");
        String ln = scanner.nextLine();
        studentService.deActivateStudentByName(fn, ln);
        System.out.println("Student deactivated successfully.");
    }

    /**
     * Displays the available student management menu options to the console.
     */
    private void showStudentMenu() {
        System.out.println("\n=== Running Student Management Service ===");
        System.out.println(StudentMenuOptions.ADD);
        System.out.println(StudentMenuOptions.DISPLAY_ALL);
        System.out.println(StudentMenuOptions.SEARCH);
        System.out.println(StudentMenuOptions.DEACTIVATE);
        System.out.println(StudentMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }
}