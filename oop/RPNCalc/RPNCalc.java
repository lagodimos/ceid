import java.util.Scanner;

// V1
//import java.util.Stack;

public class RPNCalc {

    private static class CalculatorStack {
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

    private enum InputType {
        OPERAND,
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        EVALUATE,
        INVALID,
        QUIT
    }

    private static String expression;
    private static Scanner inputScanner;
    private static Scanner expressionScanner;
    private static Integer operand;
    private static InputType inputType;
    private static CalculatorStack stack;

    // V1
    // private static Stack<Integer> stack;

    // V2
    // private static final int stackSize = 50;
    // private static int stackPointer;
    // private static int[] stack;

    public static void main(String args[]) {

        // V1
        // stack = new Stack<Integer>();

        // V2
        // stackPointer = 0;
        // stack = new int[stackSize];

        stack = new CalculatorStack(50);

        inputScanner = new Scanner(System.in);

        System.out.println("\n=== RPN Calculator ===\n");

        while (inputType != InputType.QUIT) {

            expression = getExpression(inputScanner);
            expressionScanner = new Scanner(expression).useDelimiter(" ");

            while (expressionScanner.hasNext()) {
                inputType = getOp(expressionScanner);

                switch (inputType) {
                    case OPERAND:
                        putInStack(operand);
                        break;
                    case ADDITION:
                        add();
                        break;
                    case SUBTRACTION:
                        sub();
                        break;
                    case MULTIPLICATION:
                        mul();
                        break;
                    case DIVISION:
                        div();
                        break;
                    case EVALUATE:
                        displayResult();
                        break;
                    case QUIT:
                        System.out.println("Quitting...");
                        break;
                    case INVALID:
                        System.out.println("Invalid input!");
                        break;
                }
            }

            expressionScanner.close();
        }

        inputScanner.close();
    }

    private static InputType getOp(Scanner scanner) {
        char c;
        String nextInput;
        InputType inputType;

        nextInput = scanner.next();
        c = nextInput.charAt(0);

        if (Character.isDigit(c) || isHex(nextInput.charAt(0))) {
            operand = Integer.parseInt(Character.toString(c), 16);
            inputType = InputType.OPERAND;
        }
        else {
            switch (c) {
                case '+':
                    inputType = InputType.ADDITION;
                    break;
                case '-':
                    inputType = InputType.SUBTRACTION;
                    break;
                case '*':
                    inputType = InputType.MULTIPLICATION;
                    break;
                case '/':
                    inputType = InputType.DIVISION;
                    break;
                case '=':
                    inputType = InputType.EVALUATE;
                    break;
                case 'q':
                    inputType = InputType.QUIT;
                    break;
                default:
                    inputType = InputType.INVALID;
            }
        }

        return inputType;
    }

    private static boolean isHex(char c) {
        boolean isHex;

        if (c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
            isHex = true;
        }
        else {
            isHex = false;
        }

        return isHex;
    }

    private static String getExpression(Scanner scanner) {
        String input;

        System.out.print("Expression to evaluate: ");
        input = scanner.nextLine();

        return input;
    }

    private static void putInStack(int number) {
        // V2
        // push(number);

        stack.push(number);
    }

    private static void add() {
        // V2
        // push(pop() + pop());

        stack.push(stack.pop() + stack.pop());
    }

    private static void sub() {
        // V2
        // Integer num = pop();
        // push(pop() - num);


        Integer num = stack.pop();

        stack.push(stack.pop() - num);
    }

    private static void mul() {
        // V2
        // push(pop() * pop());

        stack.push(stack.pop() * stack.pop());
    }

    private static void div() {
        // V2
        // Integer divisor = pop();

        Integer divisor = stack.pop();

        if (divisor != 0) {
            // V2
            // push(pop() / divisor);

            stack.push(stack.pop() / divisor);
        }
        else {

            // V2
            // push(divisor);

            stack.push(divisor);
            System.out.println("Invalid operation (division by 0). Operation ignored!");
        }
    }

    private static void displayResult() {
        System.out.println("Result: " + stack.pop());

        // V2
        // System.out.println("Result: " + pop());
    }

    // V2
    // private static void push(int num) {
    //     if (stackPointer <= stackSize) {
    //         stack[stackPointer] = num;
    //         stackPointer++;
    //     }
    //     else {
    //         System.out.println("Stack overflow!");
    //     }
    // }

    // private static int pop() {
    //     if (stackPointer >= 1) {
    //         stackPointer--;
    //         return stack[stackPointer];
    //     }
    //     else {
    //         System.out.println("Stack underflow!");
    //         return 0;
    //     }
    // }
}
