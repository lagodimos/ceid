import java.util.Stack;

class Adder {
    private Stack<Double> stack;

    Adder(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        stack.push(stack.pop() + stack.pop());
    }

    public static void operate(Stack<Double> stack) {
        stack.push(stack.pop() + stack.pop());
    }
}
