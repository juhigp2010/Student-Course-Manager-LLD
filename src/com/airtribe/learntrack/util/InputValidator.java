package com.airtribe.learntrack.util;

import java.util.regex.Pattern;

/**
 * The {@code InputValidator} class provides utility methods to validate various user inputs.
 */
public class InputValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private InputValidator() {
    }
    /**
     * Validates if a given email string matches the standard email regex pattern.
     *
     * @param email the email string to validate
     * @return {@code true} if the email is valid, {@code false} otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.matches(EMAIL_REGEX, email);
    }

}
