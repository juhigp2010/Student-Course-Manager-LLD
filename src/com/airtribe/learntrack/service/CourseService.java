package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.List;

/**
 * The {@code CourseService} class provides business logic operations for managing courses.
 * It acts as an intermediary between the UI layer and the course repository.
 */
public class CourseService {
    private final CourseRepository courseRepository;

    /**
     * Constructs a {@code CourseService} with the specified course repository.
     *
     * @param courseRepository the repository used to access and modify course data
     */
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Creates a new course and adds it to the repository.
     *
     * @param courseName      the name of the course
     * @param description     the description of the course
     * @param durationInWeeks the duration of the course in weeks
     */
    public void addNewCourse(String courseName, String description, String durationInWeeks) {
        Course course = new Course(courseName, description, durationInWeeks);
        courseRepository.addNewCourse(course);
    }

    /**
     * Updates the active status of a course.
     *
     * @param id     the ID of the course to update
     * @param status the new active status
     * @throws EntityNotFoundException if the course is not found
     */
    public void UpdateCourseStatus(int id, boolean status) throws EntityNotFoundException {
        courseRepository.updateCourseStatus(id, status);
    }

    /**
     * Retrieves and prints all courses from the repository.
     */
    public void findAllCourses() {
        List<Course> courseList = courseRepository.findAllCourse();
        for (Course c : courseList) {
            System.out.println(c);
        }
    }

    /**
     * Finds a course by its ID and prints its details.
     *
     * @param id the ID of the course to find
     * @throws EntityNotFoundException if the course is not found
     */
    public void findCourse(int id) throws EntityNotFoundException {
        System.out.println(courseRepository.findCourseById(id));
    }
}
