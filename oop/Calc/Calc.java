import java.util.Stack;

public class Calc {
    static Double d1, d2;
    static Stack<Double> stack;

    static Adder adder;

    static StackCalc calc;

    public static void main(String[] args) {
        d1 = Double.valueOf(20);
        d2 = Double.valueOf(40);
        stack = new Stack<>();

        // V3.1
        stack.push(d1);
        stack.push(d2);
        stack.push(stack.pop() + stack.pop());
        System.out.println("Result: " + stack.pop());

        // V3.2
        stack.push(d1);
        stack.push(d2);
        add();
        System.out.println("Result: " + stack.pop());

        // V3.3
        stack.push(d1);
        stack.push(d2);
        adder.operate(stack);
        System.out.println("Result: " + stack.pop());

        // V3.4 / V3.5
        adder = new Adder(stack);
        stack.push(d1);
        stack.push(d2);
        adder.operate();
        System.out.println("Result: " + stack.pop());

        // V3.6
        calc = new StackCalc(stack);
        stack.push(d1);
        stack.push(d2);
        calc.add();
        System.out.println("Result: " + stack.pop());
        stack.push(d1);
        stack.push(d2);
        calc.sub();
        System.out.println("Result: " + stack.pop());
        stack.push(d1);
        stack.push(d2);
        calc.mul();
        System.out.println("Result: " + stack.pop());
        stack.push(d1);
        stack.push(d2);
        calc.div();
        System.out.println("Result: " + stack.pop());
    }

    private static void add() {
        stack.push(stack.pop() + stack.pop());
    }
}
