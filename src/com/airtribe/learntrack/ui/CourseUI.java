package com.airtribe.learntrack.ui;
import com.airtribe.learntrack.constants.CourseMenuOptions;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;

import java.util.Scanner;

/**
 * The {@code CourseUI} class provides a console-based user interface for managing courses.
 * It interacts with the {@link CourseService} to execute course-related operations.
 */
public class CourseUI {
    private final Scanner scanner;
    private final CourseService courseService;

    /**
     * Constructs a {@code CourseUI} instance.
     *
     * @param scanner       the {@link Scanner} used to read user input from the console
     * @param courseService the service used to handle course-related business logic
     */
    public CourseUI(Scanner scanner, CourseService courseService) {
        this.scanner = scanner;
        this.courseService = courseService;
    }

    /**
     * Displays and handles the course management menu.
     * Continuously prompts the user for choices until they choose to exit to the main menu.
     */
    public void handleCourseMenu() {
        boolean backToMain = false;
        while (!backToMain) {
            showCourseMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addNewCourse();
                    case 2 -> courseService.findAllCourses();
                    case 3 -> updateCourseStatus();
                    case 4 -> {
                        System.out.println("Closing the Course service.");
                        backToMain = true;
                    }
                    default -> System.out.println("Invalid Option");
                }
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Prompts the user for course details and creates a new course.
     */
    // Helper for Case 1
    private void addNewCourse() {
        System.out.print("Please enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Please enter course description: ");
        String courseDescription = scanner.nextLine();
        System.out.print("Please enter course duration in weeks: ");
        String duration = scanner.nextLine();

        courseService.addNewCourse(courseName, courseDescription, duration);
        System.out.println("Course has been added successfully..!!");
    }

    /**
     * Prompts the user for a course ID and a new active/inactive status, then updates the course.
     *
     * @throws EntityNotFoundException if the course is not found
     */
    // Helper for Case 3
    private void updateCourseStatus() throws EntityNotFoundException {
        System.out.print("Enter Course ID to update: ");
        int courseId = Integer.parseInt(scanner.nextLine());

        System.out.println("Select New Status:");
        System.out.println("1. Active");
        System.out.println("2. Inactive");
        System.out.print("Selection: ");

        int statusChoice = Integer.parseInt(scanner.nextLine());

        Boolean newStatus = null;
        if (statusChoice == 1) {
            newStatus = true;
        } else if (statusChoice == 2) {
            newStatus = false;
        }

        if (newStatus != null) {
            courseService.UpdateCourseStatus(courseId, newStatus);
            String statusText = newStatus ? "ACTIVE" : "INACTIVE";
            System.out.println("Success: Course " + courseId + " is now " + statusText);
        } else {
            System.out.println("Invalid selection. Status update cancelled.");
        }
    }

    /**
     * Displays the available course management menu options to the console.
     */
    private void showCourseMenu() {
        System.out.println("\n=== Running Course Management Service ===");
        System.out.println(CourseMenuOptions.ADD_NEW_COURSE);
        System.out.println(CourseMenuOptions.All_COURSES);
        System.out.println(CourseMenuOptions.DEACTIVATE);
        System.out.println(CourseMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }
}
