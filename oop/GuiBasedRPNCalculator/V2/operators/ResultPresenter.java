package operators;

import java.util.Stack;

public class ResultPresenter {
    private Stack<Double> stack;

    public ResultPresenter(Stack<Double> stack) {
        this.stack = stack;
    }

    public void operate() {
        Double num;

        if ( !stack.isEmpty() ) {
            num = stack.pop();
            System.out.println(num.toString());
        }
        else {
            System.out.println("No result available.");
        }
    }
}
