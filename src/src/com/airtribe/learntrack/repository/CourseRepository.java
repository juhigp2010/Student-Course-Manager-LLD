package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public void addNewCourse(Course course) {
        courses.add(course);
    }

    public List<Course> findAllCourse() {
        return courses;
    }
    public Course findCourseById(int id) throws EntityNotFoundException
    {
        for(Course c:courses)
        {
            if(c.getId()==id)
                return c;
        }
        throw new EntityNotFoundException("Course not found with given id "+ id);
    }
    public void updateCourseStatus(int id, boolean status) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id){
                c.setActive(status);
                return;}
        }
        throw new EntityNotFoundException("Couldn't found the course with given id+ /n");

    }

}

