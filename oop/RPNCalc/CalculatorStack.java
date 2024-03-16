public class CalculatorStack {
    private final int stackSize;
    private int stackPointer;
    private int[] stack;

    CalculatorStack(int stackSize) {
        this.stackSize = stackSize;
        this.stackPointer = 0;
        this.stack = new int[this.stackSize];
    }

    public void push(int num) {
        if (stackPointer <= stackSize) {
            stack[stackPointer] = num;
            stackPointer++;
        }
        else {
            System.out.println("Stack overflow!");
        }
    }

    public int pop() {
        if (stackPointer >= 1) {
            stackPointer--;
            return stack[stackPointer];
        }
        else {
            System.out.println("Stack underflow!");
            return 0;
        }
    }
}
