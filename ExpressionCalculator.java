import java.util.Scanner;
import java.util.Stack;

public class ExpressionCalculator {

    // Function to check operator precedence
    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Function to perform operation
    static int applyOperation(int a, int b, char op) {

        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }

        return 0;
    }

    public static int evaluate(String expression) {

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Skip spaces
            if (ch == ' ')
                continue;

            // If digit, build full number
            if (Character.isDigit(ch)) {

                int num = 0;

                while (i < expression.length() &&
                        Character.isDigit(expression.charAt(i))) {

                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }

                values.push(num);
                i--;

            }

            // If opening bracket
            else if (ch == '(') {
                operators.push(ch);
            }

            // If closing bracket
            else if (ch == ')') {

                while (operators.peek() != '(') {

                    int b = values.pop();
                    int a = values.pop();
                    char op = operators.pop();

                    values.push(applyOperation(a, b, op));
                }

                operators.pop();
            }

            // If operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (!operators.empty() &&
                        precedence(operators.peek()) >= precedence(ch)) {

                    int b = values.pop();
                    int a = values.pop();
                    char op = operators.pop();

                    values.push(applyOperation(a, b, op));
                }

                operators.push(ch);
            }
        }

        while (!operators.empty()) {

            int b = values.pop();
            int a = values.pop();
            char op = operators.pop();

            values.push(applyOperation(a, b, op));
        }

        return values.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String exp = sc.nextLine();

        int result = evaluate(exp);

        System.out.println("Result = " + result);

        sc.close();
    }
}