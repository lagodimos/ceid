import java.util.Stack;

class StackCalc {
    private Stack<Double> stack;

    StackCalc(Stack<Double> stack) {
        this.stack = stack;
    }

    public void add() {
        stack.push(stack.pop() + stack.pop());
    }

    public void sub() {
        Double num = stack.pop();

        stack.push(stack.pop() - num);
    }

    public void mul() {
        stack.push(stack.pop() * stack.pop());
    }

    public void div() {
        Double divisor = stack.pop();

        if (divisor != 0) {
            stack.push(stack.pop() / divisor);
        }
        else {
            stack.push(divisor);
            System.out.println("Invalid operation (division by 0). Operation ignored!");
        }
    }
}
