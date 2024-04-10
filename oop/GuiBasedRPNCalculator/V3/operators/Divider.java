package operators;

import java.util.Stack;

public class Divider extends Operator {
    public Divider(Stack<Double> stack) {
        super(stack);
    }

    @Override
    public void operate() {
        if (stack.size() >= 2) {
            Double divisor = stack.pop();

            if (divisor != 0) {
                stack.push(stack.pop() / divisor);
            }
            else {
                stack.push(divisor);
                System.out.println("Invalid operation (division by 0). Operation ignored!");
            }
        }
        else {
            System.out.println("Not enough operands for this operation.");
        }

    }
}
