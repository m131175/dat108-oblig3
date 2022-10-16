package no.hvl.dat108.shopping.util;

public class InputValidator {

    //@Value("${app.user.password}") private static String PASSWORD; THIS SOMEHOW DOESN'T WORK IN THE .equals????
    private static String PASSWORD = "admin";

    public static boolean isValidPassword(String password) {
        return password != null && password.equals(PASSWORD);
    }
}
