import java.util.Stack;

public class Multiplier {
    private Stack<Double> stack;

    public Multiplier(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        if (stack.size() >= 2) {
            stack.push(stack.pop() * stack.pop());
        }
        else {
            System.out.println("Not enough operands for this operation.");
        }
    }
}
