import java.util.Stack;

public class Adder {
    private Stack<Double> stack;

    public Adder(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        if (stack.size() >= 2) {
            stack.push(stack.pop() + stack.pop());
        }
        else {
            System.out.println("Not enough operands for this operation.");
        }
    }
}
