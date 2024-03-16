import java.util.Scanner;

public class RPNCalc {

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
    private static Scanner scanner;
    private static Integer operand;
    private static InputType inputType;
    private static CalculatorStack stack;

    public static void main(String args[]) {

        stack = new CalculatorStack(50);

        System.out.println("\n=== RPN Calculator ===\n");

        expression = getExpression();
        scanner = new Scanner(expression).useDelimiter(" ");

        while (scanner.hasNext() && inputType != InputType.QUIT) {
            inputType = getOp(scanner);

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

        scanner.close();
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

    private static String getExpression() {
        String input;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Expression to evaluate: ");
        input = scanner.nextLine();
        scanner.close();

        return input;
    }

    private static void putInStack(int number) {
        stack.push(number);
    }

    private static void add() {
        stack.push(stack.pop() + stack.pop());
    }

    private static void sub() {
        Integer num = stack.pop();

        stack.push(stack.pop() - num);
    }

    private static void mul() {
        stack.push(stack.pop() * stack.pop());
    }

    private static void div() {
        Integer divisor = stack.pop();

        if (divisor != 0) {
            stack.push(stack.pop() / divisor);
        }
        else {
            stack.push(divisor);
            System.out.println("Invalid operation (division by 0). Operation ignored!");
        }
    }

    private static void displayResult() {
        System.out.println("Result: " + stack.pop());
    }
}
