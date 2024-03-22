import java.util.Stack;

public class Multiplier {
    private Stack<Double> stack;
    
    Multiplier(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        stack.push(stack.pop() * stack.pop());
    }
}
