package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.constants.*;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository);
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, studentRepository, courseRepository);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    handleStudentMenu(scanner, studentService);
                    break;
                case 2:
                    handleCourseMenu(scanner, courseService);
                    break;
                case 3:
                    handleEnrollmentMenu(scanner, enrollmentService);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static void handleEnrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {
        boolean backToMain = false;
        while (!backToMain) {
            showEnrollmentMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        int studentId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Course ID: ");
                        int courseId = Integer.parseInt(scanner.nextLine());
                        enrollmentService.enrollStudent(studentId, courseId);
                        break;
                    case 2:
                        System.out.print("Enter Student ID to view enrollments: ");
                        int sId = Integer.parseInt(scanner.nextLine());
                        enrollmentService.viewStudentEnrollments(sId);
                        break;
                    case 3:
                        System.out.print("Enter Enrollment ID: ");
                        int eId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Select New Status: ");
                        System.out.println("1. COMPLETED");
                        System.out.println("2. CANCELLED");
                        System.out.print("Selection: ");
                        int statusChoice = Integer.parseInt(scanner.nextLine());
                        EnrollmentStatus newStatus;
                        if (statusChoice == 1) {
                            newStatus = EnrollmentStatus.COMPLETED;
                        } else if (statusChoice == 2) {
                            newStatus = EnrollmentStatus.CANCELLED;
                        } else {
                            System.out.println("Invalid status selection.");
                            break;
                        }
                        enrollmentService.updateStatus(eId, newStatus);
                        break;
                    case 4:
                        backToMain = true;
                        break;
                }
            } catch (EntityNotFoundException e) {
                System.out.print(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (Exception e) {
                System.out.println("please enter the choice in number");
            }
        }
    }

    private static void handleCourseMenu(Scanner scanner, CourseService courseService) {
        boolean backToMain = false;
        while (!backToMain) {
            showCourseMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Please enter course name: ");
                        String courseName = scanner.nextLine();
                        System.out.print("please enter course description: ");
                        String courseDescription = scanner.nextLine();
                        System.out.print("Please enter course duration in weeks: ");
                        String duration = scanner.nextLine();
                        courseService.addNewCourse(courseName, courseDescription, duration);
                        System.out.println("Course has been added successfully..!!");
                        break;

                    case 2:
                        courseService.findAllCourses();
                        break;
                    case 3:
                        System.out.print("Enter Course ID to update: ");
                        int courseId = Integer.parseInt(scanner.nextLine());
                        System.out.println("Select New Status:");
                        System.out.println("1. Active");
                        System.out.println("2. Inactive");
                        System.out.print("Selection: ");
                        int statusChoice = Integer.parseInt(scanner.nextLine());
                        boolean newStatus;
                        if (statusChoice == 1) {
                            newStatus = true;
                        } else if (statusChoice == 2) {
                            newStatus = false;
                        } else {
                            System.out.println("Invalid selection. Status update cancelled.");
                            break;
                        }
                        courseService.UpdateCourseStatus(courseId, newStatus);
                        String statusText = newStatus ? "ACTIVE" : "INACTIVE";
                        System.out.println("Success: Course " + courseId + " is now " + statusText);
                        break;
                    case 4:
                        System.out.print("Closing the Course service.");
                        backToMain = true;

                }
            } catch (EntityNotFoundException e) {
                System.out.print(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (Exception e) {
                System.out.println("please enter the choice in number");
            }
        }
    }

    private static void handleStudentMenu(Scanner scanner, StudentService studentService) {
        boolean backToMain = false;
        while (!backToMain) {
            showStudentMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
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
                        break;

                    case 2:
                        studentService.displayAllStudents();
                        break;

                    case 3:
                        System.out.print("Please enter the student id you want to search: ");
                        int studentId = Integer.parseInt(scanner.nextLine());
                        studentService.findStudentById(studentId);
                        break;

                    case 4:
                        System.out.print("Deactivate student by: 1. ID | 2. Name: ");
                        int deactivationChoice = Integer.parseInt(scanner.nextLine());
                        switch (deactivationChoice) {
                            case 1:
                                System.out.print("Enter Student ID: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                studentService.deActivateStudentById(id);
                                break;
                            case 2:
                                System.out.print("First Name: ");
                                String fn = scanner.nextLine();
                                System.out.print("Last Name: ");
                                String ln = scanner.nextLine();
                                studentService.deActivateStudentByName(fn, ln);
                                break;
                            default:
                                System.out.println("Invalid selection.");
                                break;
                        }
                        break;

                    case 5:
                        System.out.print("Closing the Student service.");
                        backToMain = true;
                        break;

                    default:
                        System.out.println("Invalid Option");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric choice or ID.");
            } catch (EntityNotFoundException e) {
                System.out.println("Could not found Student with given data");
            } catch (Exception e) {
                System.out.println("please enter the choice in number");
            }
        }

        }

    private static void showMainMenu() {
        System.out.println("====Student & Course Management System ====");
        System.out.println(MainMenuOptions.STUDENTMANAGEMENT);
        System.out.println(MainMenuOptions.COURSEMANAGEMENT);
        System.out.println(MainMenuOptions.ENROLLMENTMANGEMENT);
        System.out.println(MainMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }

    private static void showStudentMenu() {
        System.out.println("===Running Student Management Service===");
        System.out.println(StudentMenuOptions.ADD);
        System.out.println(StudentMenuOptions.DISPLAY_ALL);
        System.out.println(StudentMenuOptions.SEARCH);
        System.out.println(StudentMenuOptions.DEACTIVATE);
        System.out.println(StudentMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }

    private static void showCourseMenu() {
        System.out.println("===Running Course Management Service===");
        System.out.println(CourseMenuOptions.ADD_NEW_COURSE);
        System.out.println(CourseMenuOptions.All_COURSES);
        System.out.println(CourseMenuOptions.DEACTIVATE);
        System.out.println(CourseMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }

    private static void showEnrollmentMenu() {
        System.out.println("===Running Enrollment Service===");
        System.out.println(EnrollmentMenuOptions.ENROLL_STUDENT);
        System.out.println(EnrollmentMenuOptions.DISPLAY_ENROLMENT_STUDENT);
        System.out.println(EnrollmentMenuOptions.UPDATE_ENROLLMENT_STATUS);
        System.out.println(EnrollmentMenuOptions.EXIT);
        System.out.print("Please select your choice: ");
    }
}

