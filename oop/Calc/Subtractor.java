import java.util.Stack;

public class Subtractor {
    private Stack<Double> stack;
    
    Subtractor(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        Double num = stack.pop();

        stack.push(stack.pop() - num);
    }
}