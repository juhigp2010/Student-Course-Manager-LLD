package com.airtribe.learntrack.repository;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CourseRepository} class provides an in-memory storage mechanism for {@link Course} entities.
 */
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    /**
     * Adds a new course to the repository.
     *
     * @param course the course to add
     */
    public void addNewCourse(Course course) {
        courses.add(course);
    }

    /**
     * Retrieves a list of all courses in the repository.
     *
     * @return a list of {@link Course} objects
     */
    public List<Course> findAllCourse() {
        return courses;
    }

    /**
     * Finds a course by its unique ID.
     *
     * @param id the ID of the course
     * @return the {@link Course} matching the given ID
     * @throws EntityNotFoundException if the course is not found
     */
    public Course findCourseById(int id) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id)
                return c;
        }
        throw new EntityNotFoundException("Course not found with given id " + id);
    }

    /**
     * Updates the active status of a given course.
     *
     * @param id     the ID of the course to update
     * @param status the new status to apply
     * @throws EntityNotFoundException if the course is not found
     */
    public void updateCourseStatus(int id, boolean status) throws EntityNotFoundException {
        for (Course c : courses) {
            if (c.getId() == id) {
                c.setActive(status);
                return;
            }
        }
        throw new EntityNotFoundException("Couldn't found the course with given id  "+id);
    }
}

