import java.util.Scanner;
import java.util.Stack;

public class ReverseSentenceStack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        // Split sentence into words
        String[] words = sentence.split(" ");

        // Push words into stack
        for (String word : words) {
            stack.push(word);
        }

        System.out.println("Reversed sentence:");

        // Pop words to reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        sc.close();
    }
}