package operators;

import java.util.Stack;

public class Adder extends Operator {
    public Adder(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void operate() {
        if (stack.size() >= 2) {
            stack.push(stack.pop() + stack.pop());
        }
        else {
            System.out.println("Not enough operands for this operation.");
        }
    }
}
