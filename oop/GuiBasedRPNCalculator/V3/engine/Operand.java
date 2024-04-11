package engine;

import java.util.Stack;

public class Operand implements OperandIf {
    private Stack<Double> stack;
    private StringBuffer digits;

    public Operand(Stack<Double> stack) {
        digits = new StringBuffer();

        this.stack = stack;
    }

    public void addDigit(char digit) {
        digits.append(digit);
        System.out.println(digits);
    }

    public void deleteLastDigit() {
        if ( !digits.isEmpty() ) {
            digits.deleteCharAt(digits.length() - 1);
            System.out.println(digits);
        }
        else {
            System.out.println("There is no digit to erase.");
        }
    }

    public void complete() {
        if ( !digits.isEmpty() ) {
            stack.push(Double.valueOf(digits.toString()));
            clearEntry();
        }
        else {
            System.out.println("No number to push to the stack.");
        }
    }

    public void reset() {
        clearEntry();
        stack.removeAllElements();
    }

    public void clearEntry() {
        digits.setLength(0);
    }
}
