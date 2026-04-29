package com.airtribe.learntrack.exception;

/**
 * Exception thrown when the provided input fails validation constraints.
 */
public class InvalidInputException extends Exception{
    /**
     * Constructs a new {@code InvalidInputException} with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidInputException(String message)
    {
        super(message);
    }
}
