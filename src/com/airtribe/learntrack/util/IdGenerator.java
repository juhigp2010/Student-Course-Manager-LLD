package com.airtribe.learntrack.util;

/**
 * The {@code IdGenerator} class provides utility methods to generate unique IDs
 * for different entities within the application.
 */
public class IdGenerator {

    private static int studentCounter = 1000;
    private static int trainerCounter = 5000;
    private static int courseCounter = 2000;
    private static int enrollmentCounter = 10000;
    /**
     * Generates and returns the next available unique ID for a Student.
     *
     * @return the generated student ID
     */
    public static int getNextStudentId() {
        return ++studentCounter;
    }

    /**
     * Generates and returns the next available unique ID for a Trainer.
     *
     * @return the generated trainer ID
     */
    public static int getNextTrainerId() {
        return ++trainerCounter;
    }

    /**
     * Generates and returns the next available unique ID for a Course.
     *
     * @return the generated course ID
     */
    public static int getNextCourseId() {
        return ++courseCounter;
    }

    /**
     * Generates and returns the next available unique ID for an Enrollment.
     *
     * @return the generated enrollment ID
     */
    public static int getNextEnrollmentId() {
        return ++enrollmentCounter;
    }
}
