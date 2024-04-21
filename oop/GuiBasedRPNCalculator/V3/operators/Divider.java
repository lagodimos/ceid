package operators;

import java.util.Stack;
import java.util.EmptyStackException;

public class Divider extends Operator {
    public Divider(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void operate() {
        try {
            Double divisor = stack.pop();

            try {
                stack.push(stack.pop() / divisor);
            }
            catch (ArithmeticException e) {
                stack.push(divisor);
                System.out.println("Attempted to divide by 0. Operation ignored!");
            }
        }
        catch (EmptyStackException e) {
            System.out.println("Not enough operands for this operation.");
        }
    }
}
