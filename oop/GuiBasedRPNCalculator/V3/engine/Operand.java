package engine;

import java.util.Stack;

import javax.swing.JTextField;

public class Operand implements OperandIf {
    private Stack<Double> stack;
    private StringBuffer stringBuffer;

    private JTextField display;

    public Operand(Stack<Double> stack) {
        stringBuffer = new StringBuffer();

        this.stack = stack;
    }

    public void addDigit(char digit) {
        stringBuffer.append(digit);
        presentResult();
    }

    public void deleteLastDigit() {
        try {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("No digit to erase!");
        }

        presentResult();
    }

    public void complete() {
        if (stringBuffer.length() > 0) {
            stack.push(Double.valueOf(stringBuffer.toString()));
            clearEntry();
        }
        else {
            System.out.println("No number to push to the stack!");
        }
        presentResult();
    }

    public void reset() {
        clearEntry();
        stack.removeAllElements();
    }

    public void clearEntry() {
        stringBuffer.setLength(0);
    }

    @Override
    public void setDisplay(JTextField display) {
        this.display = display;
    }

    private void presentResult() {
        if (stringBuffer.length() > 0) System.out.println(stringBuffer);
        display.setText( stringBuffer.toString() );
    }
}
