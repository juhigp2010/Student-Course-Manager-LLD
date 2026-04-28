package com.airtribe.learntrack.entity;

/**
 * Represents a trainer entity in the LearnTrack system.
 * A trainer extends {@link Person} and includes specific course expertise.
 */
public class Trainer extends Person{
    /**
     * Gets the course expertise of the trainer.
     *
     * @return the course expertise
     */
    public String getCourseExpert() {
        return courseExpert;
    }

    /**
     * Sets the course expertise of the trainer.
     *
     * @param courseExpert the new course expertise
     */
    public void setCourseExpert(String courseExpert) {
        this.courseExpert = courseExpert;
    }

    private String courseExpert;

    /**
     * Constructs a new {@code Trainer} with the specified details.
     *
     * @param id           the unique identifier of the trainer
     * @param firstName    the first name of the trainer
     * @param lastName     the last name of the trainer
     * @param email        the email address of the trainer
     * @param courseExpert the course expertise of the trainer
     */
    public Trainer(int id, String firstName, String lastName, String email, String courseExpert) {
        super(id, firstName, lastName, email);
        this.courseExpert=courseExpert;
    }


}
