package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int studentCounter = 1000;
    private static int trainerCounter = 5000;
    private static int courseCounter = 2000;
    private static int enrollmentCounter = 10000;
    public static int getNextStudentId() {
        return ++studentCounter;
    }

    public static int getNextTrainerId() {
        return ++trainerCounter;
    }

    public static int getNextCourseId() {
        return ++courseCounter;
    }

    public static int getNextEnrollmentId() {
        return ++enrollmentCounter;
    }
}
