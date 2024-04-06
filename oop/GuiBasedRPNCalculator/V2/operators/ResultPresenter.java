package operators;

import java.util.Stack;

public class ResultPresenter {
    private Stack<Double> stack;

    public ResultPresenter(Stack<Double> stack) {
        this.stack = stack;
    }

    public Double operate() {
        Double num;

        if ( !stack.isEmpty() ) {
            num = stack.pop();
            System.out.println(num.toString());
        }
        else {
            num = 0.0;
            System.out.println("No result available.");
        }
        return num;
    }
}
