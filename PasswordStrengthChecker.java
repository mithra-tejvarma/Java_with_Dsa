import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        int score = 0;

        // Rule 1: Length check
        if (password.length() >= 8) {
            score++;
        }

        // Rule 2: Uppercase letter check
        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        // Rule 3: Lowercase letter check
        if (password.matches(".*[a-z].*")) {
            score++;
        }

        // Rule 4: Digit check
        if (password.matches(".*[0-9].*")) {
            score++;
        }

        // Rule 5: Special character check
        if (password.matches(".*[!@#$%^&*()].*")) {
            score++;
        }

        // Strength evaluation
        if (score <= 2) {
            System.out.println("Password Strength: Weak");
        } else if (score <= 4) {
            System.out.println("Password Strength: Medium");
        } else {
            System.out.println("Password Strength: Strong");
        }

        sc.close();
    }
}