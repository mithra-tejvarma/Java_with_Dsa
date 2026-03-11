import java.util.Scanner;

public class PowerOfTwoChecker {

    // Function to check power of two
    static boolean isPowerOfTwo(int n) {

        if (n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter resource size: ");
        int n = sc.nextInt();

        if (isPowerOfTwo(n))
            System.out.println(n + " is a Power of Two → Efficient for allocation");
        else
            System.out.println(n + " is NOT a Power of Two → May waste memory");

        sc.close();
    }
}