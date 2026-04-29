package com.airtribe.learntrack.exception;

/**
 * Exception thrown when an entity is not found in the repository.
 */
public class EntityNotFoundException extends Exception{
    /**
     * Constructs a new {@code EntityNotFoundException} with the specified detail message.
     *
     * @param message the detail message
     */
    public EntityNotFoundException(String message)
    {
        super(message);
    }
}
