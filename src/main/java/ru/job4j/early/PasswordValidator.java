package ru.job4j.early;

public class PasswordValidator {

    private static final String[] NOT_ALLOWED_PASSWORDS = new String[]
            {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (containSubstrings(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: "
                    + "qwerty, 12345, password, admin, user");
        }
        return containSymbols(password);
    }

    private static String containSymbols(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
            if (hasUppercase && hasLowercase && hasDigit && hasSpecial) {
                break;
            }
        }

        if (!hasUppercase) {
            throw new IllegalArgumentException("Password should contain at least one "
                    + "uppercase letter");
        }
        if (!hasLowercase) {
            throw new IllegalArgumentException("Password should contain at least one "
                    + "lowercase letter");
        }
        if (!hasDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!hasSpecial) {
            throw new IllegalArgumentException("Password should contain at least one "
                    + "special symbol");
        }
        return password;
    }

    private static boolean containSubstrings(String password) {
        for (String str : NOT_ALLOWED_PASSWORDS) {
            if (password.toLowerCase().contains(str.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
