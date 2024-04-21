package operators;

import java.util.Stack;
import java.util.EmptyStackException;

public class Subtractor extends Operator {
    public Subtractor(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void operate() {
        try {
            Double num = stack.pop();
            stack.push(stack.pop() - num);
        }
        catch (EmptyStackException e) {
            System.out.println("Not enough operands for this operation.");
        }
    }
}
