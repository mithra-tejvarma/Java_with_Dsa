import java.util.Stack;

class StackFrame {
    String functionName;

    StackFrame(String functionName) {
        this.functionName = functionName;
    }
}

public class CallStackSimulation {

    static Stack<StackFrame> callStack = new Stack<>();

    // Simulate calling a function
    public static void callFunction(String name) {
        StackFrame frame = new StackFrame(name);
        callStack.push(frame);
        System.out.println("Calling function: " + name);
        printStack();
    }

    // Simulate returning from a function
    public static void returnFunction() {
        if (!callStack.isEmpty()) {
            StackFrame frame = callStack.pop();
            System.out.println("Returning from function: " + frame.functionName);
        }
        printStack();
    }

    // Display call stack
    public static void printStack() {
        System.out.println("Current Call Stack:");

        if (callStack.isEmpty()) {
            System.out.println("[Empty]");
            return;
        }

        for (int i = callStack.size() - 1; i >= 0; i--) {
            System.out.println(callStack.get(i).functionName);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        callFunction("main()");
        callFunction("login()");
        callFunction("validateUser()");
        returnFunction();
        returnFunction();
        returnFunction();
    }
}