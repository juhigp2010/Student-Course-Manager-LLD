package com.airtribe.learntrack.entity;

/**
 * Represents a generic person entity with common attributes like ID, name, and email.
 * This class serves as a base class for other entities such as {@link Student} and {@link Trainer}.
 */
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructs a {@code Person} with an email address.
     *
     * @param id        the unique identifier of the person
     * @param firstName the first name of the person
     * @param lastName  the last name of the person
     * @param email     the email address of the person
     */
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    /**
     * Constructs a {@code Person} without an email address.
     *
     * @param id        the unique identifier of the person
     * @param firstName the first name of the person
     * @param lastName  the last name of the person
     */
    public Person(int id,String firstName,String lastName)
    {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    /**
     * Gets the unique ID of the person.
     *
     * @return the person ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique ID of the person.
     *
     * @param id the new ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the person.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the person.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Gets the full display name of the person.
     *
     * @return the combined first and last name
     */
    public String getDisplayName() {
        return firstName + " " + lastName;
    }

}
