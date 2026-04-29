package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.List;

public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addNewCourse(String courseName, String description, String durationInWeeks) {
        Course course = new Course(courseName, description, durationInWeeks);
        courseRepository.addNewCourse(course);
    }

    public void UpdateCourseStatus(int id, boolean status) throws EntityNotFoundException {
        courseRepository.updateCourseStatus(id, status);
    }

    public void findAllCourses() {
        List<Course> courseList = courseRepository.findAllCourse();
        for (Course c : courseList) {
            System.out.println(c);
        }
    }

    public void findCourse(int id) throws EntityNotFoundException {
        System.out.println(courseRepository.findCourseById(id));
    }
}
