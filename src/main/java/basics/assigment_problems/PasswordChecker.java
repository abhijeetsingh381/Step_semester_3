package main.java.basics.assigment_problems;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {

        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {

        PasswordChecker pc =
                new PasswordChecker("abcd");

        PasswordChecker pc2 =
                new PasswordChecker("abcdefghij");

        System.out.println("Password 1: " + pc.getStrength());
        System.out.println("Password 2: " + pc2.getStrength());
    }
}