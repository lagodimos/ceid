import java.util.Stack;

public class Operand implements OperandIf {
    private Stack<Double> stack;
    private StringBuffer stringBuffer;

    public Operand(Stack<Double> stack) {
        stringBuffer = new StringBuffer();

        this.stack = stack;
    }

    public void addDigit(char digit) {
        stringBuffer.append(digit);
        System.out.println(stringBuffer);
    }

    public void deleteLastDigit() {
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            System.out.println(stringBuffer);
        }
        else {
            System.out.println("There is no digit to erase.");
        }
    }

    public void complete() {
        if (stringBuffer.length() > 0) {
            stack.push(Double.valueOf(stringBuffer.toString()));
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
        stringBuffer.setLength(0);
    }
}
