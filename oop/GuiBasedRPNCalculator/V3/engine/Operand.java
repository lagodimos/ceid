package engine;

import java.util.Stack;

public class Operand implements OperandIf {
    private Stack<Double> stack;
    private String digits;

    public Operand(Stack<Double> stack) {
        digits = "";

        this.stack = stack;
    }

    public void addDigit(char digit) {
        if (digit != '\0') {
            digits += digit;
        }
        System.out.println(digits);
    }

    public void deleteLastDigit() {
        if ( !digits.isEmpty() ) {
            digits = digits.substring(0, digits.length() - 1);
            System.out.println(digits);
        }
        else {
            System.out.println("There is no digit to erase.");
        }
    }

    public void complete() {
        if ( !digits.isEmpty() ) {
            stack.push(Double.valueOf(digits));
            reset();
        }
        else {
            System.out.println("No number to push to the stack.");
        }
    }

    public void reset() {
        digits = "";
    }
}
