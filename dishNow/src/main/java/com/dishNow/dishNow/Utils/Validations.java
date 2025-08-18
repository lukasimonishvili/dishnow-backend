package com.dishNow.dishNow.Utils;

public class Validations {
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return password != null && password.matches(passwordRegex);
    }

    public static boolean isValidUsername(String username) {
        String usernameRegex = "^[a-zA-Z0-9]{3,20}$";
        return username != null && username.matches(usernameRegex);
    }

}
