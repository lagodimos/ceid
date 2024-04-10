package operators;

import java.util.Stack;

public abstract class Operator {
    protected Stack<Double> stack;

    public Operator(Stack<Double> stack) {
        this.stack = stack;
    }

    public abstract void operate();
}
