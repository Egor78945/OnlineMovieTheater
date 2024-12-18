package org.example.onlinemovietheater.authenticationservice.service.user.validator;

import org.example.onlinemovietheater.authenticationservice.model.dto.security.request.AuthenticationRequestModel;

public class UserValidator {
    public static boolean isValidEmail(String email) {
        if (email.length() <= 100 && email.length() >= 15) {
            String[] emailArr = email.split("@");
            if (emailArr.length == 2 && (emailArr[1].equals("gmail.com") || emailArr[1].equals("mail.ru")) && emailArr[0].length() <= 90) {
                for (char i : emailArr[0].toCharArray()) {
                    if (!Character.isLetterOrDigit(i)) {
                        throw new RuntimeException("Email must to contain only letters, digits and 1 dog symbol.");
                    }
                }
                return true;
            }
            throw new RuntimeException("Email must to be in this format: ***@mail.ru or ***@gmail.com.");
        }
        throw new RuntimeException("Email must to be longer 14 symbols and less than 101 symbol.");
    }

    public static boolean isValidPassword(String password) {
        if (password.length() <= 30 && password.length() >= 10) {
            for (char i : password.toCharArray()) {
                if (!Character.isLetterOrDigit(i)) {
                    throw new RuntimeException("Password must to contain only letters and digits.");
                }
            }
            return true;
        }
        throw new RuntimeException("Password must to be greater 9 symbols and less than 31 symbols.");
    }

    public static boolean isValidAuthenticationModel(AuthenticationRequestModel model) {
        return isValidEmail(model.getEmail()) && isValidPassword(model.getPassword());
    }
}
