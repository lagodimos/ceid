import java.util.Stack;

public class Subtracter {
    private Stack<Double> stack;

    public Subtracter(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        if (stack.size() >= 2) {
            Double num = stack.pop();
            stack.push(stack.pop() - num);
        }
        else {
            System.out.println("Not enough operands for this operation.");
        }
    }
}
