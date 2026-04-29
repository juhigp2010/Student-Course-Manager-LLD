package com.airtribe.learntrack;

import com.airtribe.learntrack.config.AppContainer;
import com.airtribe.learntrack.constants.*;
import java.util.Scanner;

/**
 * The {@code Main} class serves as the entry point for the Student & Course Management System.
 * It initializes the application container and handles the top-level main menu interactions.
 */
public class Main {
    /**
     * The main method that bootstraps the application.
     * It sets up the {@link AppContainer} and starts the main loop for menu processing.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            AppContainer appContainer = new AppContainer(scanner);
            boolean running = true;
            while (running) {
                showMainMenu();
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            appContainer.getStudentUI().handleStudentMenu();
                            break;
                        case 2:
                            appContainer.getCourseUI().handleCourseMenu();
                            break;
                        case 3:
                            appContainer.getEnrollmentUI().handleEnrollmentMenu();
                            break;
                        case 4:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid Option");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Please enter a valid numeric choice.");
                }
            }
        }
    }
    /**
     * Displays the main menu options to the console.
     */
    private static void showMainMenu() {
        System.out.println("====Student & Course Management System ====");
        System.out.println(MainMenuOptions.STUDENTMANAGEMENT);
        System.out.println(MainMenuOptions.COURSEMANAGEMENT);
        System.out.println(MainMenuOptions.ENROLLMENTMANGEMENT);
        System.out.println(MainMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }

}

