package com.airtribe.learntrack.service;
import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import java.util.List;

    /**
     * The {@code EnrollmentService} class handles the business logic for enrolling students
     * into courses and managing their enrollment statuses.
     */
    public class EnrollmentService {
        private final EnrollmentRepository enrollmentRepository;
        private final StudentRepository studentRepository;
        private final CourseRepository courseRepository;

        /**
         * Constructs an {@code EnrollmentService} with the required repositories.
         *
         * @param enrollmentRepo the repository for managing enrollments
         * @param studentRepo    the repository for accessing student data
         * @param courseRepo     the repository for accessing course data
         */
        public EnrollmentService(EnrollmentRepository enrollmentRepo, StudentRepository studentRepo, CourseRepository courseRepo) {
            this.enrollmentRepository = enrollmentRepo;
            this.studentRepository = studentRepo;
            this.courseRepository = courseRepo;
        }

        /**
         * Enrolls a student in a course if both exist.
         *
         * @param studentId the ID of the student to enroll
         * @param courseId  the ID of the course to enroll in
         * @throws EntityNotFoundException if the student or course is not found
         */
        public void enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
            if (studentRepository.findById(studentId) == null) {
                throw new EntityNotFoundException("Cannot enroll. Student with ID " + studentId + " not found.");
            }
            if (courseRepository.findCourseById(courseId) == null) {
                throw new EntityNotFoundException("Cannot enroll. Course with ID " + courseId + " not found.");
            }
            Enrollment newEnrollment = new Enrollment(studentId, courseId, EnrollmentStatus.ACTIVE);
            enrollmentRepository.enrollAStudent(newEnrollment);
            System.out.println("Success: Enrollment created for student " + studentId);
        }
        /**
         * Displays all enrollments for a specific student.
         *
         * @param studentId the ID of the student
         * @throws EntityNotFoundException if the student has no enrollments or is not found
         */
        public void viewStudentEnrollments(int studentId) throws EntityNotFoundException {
            List<Enrollment> studentEnrollments = enrollmentRepository.findByStudentId(studentId);
            System.out.println("--- Enrollment Records for Student ID: " + studentId + " ---");
            for (Enrollment e : studentEnrollments) {
                Course c = courseRepository.findCourseById(e.getCourseId());
                String courseName = (c != null) ? c.getCourseName() : "Unknown Course";
                System.out.println("ID: " + e.getId() + " | Course: " + courseName + " | Status: " + e.getStatus());
            }
        }
        /**
         * Updates the status of an existing enrollment.
         *
         * @param enrollmentId the ID of the enrollment to update
         * @param status       the new enrollment status
         * @throws EntityNotFoundException if the enrollment is not found
         */
        public void updateStatus(int enrollmentId, EnrollmentStatus status) throws EntityNotFoundException {
            enrollmentRepository.updateEnrollmentStatus(enrollmentId, status);
            System.out.println("Success: Enrollment " + enrollmentId + " marked as " + status);
        }
    }

