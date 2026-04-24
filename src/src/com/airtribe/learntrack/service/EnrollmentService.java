package com.airtribe.learntrack.service;
import com.airtribe.learntrack.constants.EnrollmentStatus;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import java.util.List;

    public class EnrollmentService {
        private final EnrollmentRepository enrollmentRepository;
        private final StudentRepository studentRepository;
        private final CourseRepository courseRepository;

        public EnrollmentService(EnrollmentRepository enrollmentRepo, StudentRepository studentRepo, CourseRepository courseRepo) {
            this.enrollmentRepository = enrollmentRepo;
            this.studentRepository = studentRepo;
            this.courseRepository = courseRepo;
        }

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
        public void viewStudentEnrollments(int studentId) throws EntityNotFoundException {
            List<Enrollment> studentEnrollments = enrollmentRepository.findByStudentId(studentId);
            System.out.println("--- Enrollment Records for Student ID: " + studentId + " ---");
            for (Enrollment e : studentEnrollments) {
                Course c = courseRepository.findCourseById(e.getCourseId());
                String courseName = (c != null) ? c.getCourseName() : "Unknown Course";
                System.out.println("ID: " + e.getId() + " | Course: " + courseName + " | Status: " + e.getStatus());
            }
        }
        public void updateStatus(int enrollmentId, EnrollmentStatus status) throws EntityNotFoundException {
            enrollmentRepository.updateEnrollmentStatus(enrollmentId, status);
            System.out.println("Success: Enrollment " + enrollmentId + " marked as " + status);
        }
    }

