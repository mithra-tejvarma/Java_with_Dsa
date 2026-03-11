import java.util.Scanner;

public class EmailValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        // Regular expression for email validation
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email.matches(emailPattern)) {
            System.out.println("Valid Email Address");
        } else {
            System.out.println("Invalid Email Address");
        }

        sc.close();
    }
}