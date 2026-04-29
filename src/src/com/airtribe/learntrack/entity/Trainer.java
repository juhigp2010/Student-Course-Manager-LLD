package com.airtribe.learntrack.entity;

public class Trainer extends Person{
    public String getCourseExpert() {
        return courseExpert;
    }

    public void setCourseExpert(String courseExpert) {
        this.courseExpert = courseExpert;
    }

    private String courseExpert;

    public Trainer(int id, String firstName, String lastName, String email, String courseExpert) {
        super(id, firstName, lastName, email);
        this.courseExpert=courseExpert;
    }


}
