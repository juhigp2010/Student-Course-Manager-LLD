package com.airtribe.learntrack.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$";

    private InputValidator() {
    }

    public static boolean isValidName(String name) {
        return name != null && name.trim().length() > 3;
    }

    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return Pattern.matches(EMAIL_REGEX, email);
    }

}
