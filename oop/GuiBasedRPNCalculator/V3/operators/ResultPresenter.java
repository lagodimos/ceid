package operators;

import java.util.Stack;

public class ResultPresenter extends Operator {
    public ResultPresenter(Stack<Double> stack) {
        super(stack);
    }

    public void operate() {
        Double num;

        if ( !stack.isEmpty() ) {
            num = stack.pop();
            System.out.println(num);
        }
        else {
            System.out.println("No result available.");
        }
    }
}
