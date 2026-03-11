import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketValidator {

    // Function to check if brackets match
    static boolean isMatchingPair(char open, char close) {
        if (open == '(' && close == ')')
            return true;
        if (open == '{' && close == '}')
            return true;
        if (open == '[' && close == ']')
            return true;

        return false;
    }

    // Function to check if expression is balanced
    static boolean isBalanced(String expr) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++) {

            char ch = expr.charAt(i);

            // If opening bracket push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // If closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {

                // If stack empty → invalid
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if (!isMatchingPair(top, ch))
                    return false;
            }
        }

        // If stack empty → balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = sc.nextLine();

        if (isBalanced(expression))
            System.out.println("Brackets are Balanced");
        else
            System.out.println("Brackets are NOT Balanced");

        sc.close();
    }
}