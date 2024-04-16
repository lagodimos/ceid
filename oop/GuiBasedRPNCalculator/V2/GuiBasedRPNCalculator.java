import java.util.Stack;

public class GuiBasedRPNCalculator {
    private static Stack<Double> stack;

    private static Operand operand;
    private static Adder adder;
    private static Subtracter subtracter;
    private static Multiplier multiplier;
    private static Divider divider;
    private static ResultPresenter resultPresenter;

    private static CalculatorGui calculator;

    public static void main(String[] args) {

        stack = new Stack<>();

        operand = new Operand(stack);
        adder = new Adder(stack);
        subtracter = new Subtracter(stack);
        multiplier = new Multiplier(stack);
        divider = new Divider(stack);
        resultPresenter = new ResultPresenter(stack);
        calculator = new CalculatorGui(operand, adder, subtracter, multiplier, divider, resultPresenter);
    }
}
