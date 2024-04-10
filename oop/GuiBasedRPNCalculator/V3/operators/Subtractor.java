package operators;

import java.util.Stack;

public class Subtractor extends Operator {
    public Subtractor(Stack<Double> stack) {
        super(stack);
    }

    @Override
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
