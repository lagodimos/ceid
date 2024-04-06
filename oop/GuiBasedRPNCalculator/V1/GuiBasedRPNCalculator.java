import java.util.Stack;

import operators.*;
import engine.*;

import gui.*;

public class GuiBasedRPNCalculator {
    private static Stack<Double> stack;

    private static Operand operand;
    private static Adder adder;
    private static ResultPresenter resultPresenter;

    private static CalculatorGui calculator;

    public static void main(String[] args) {

        stack = new Stack<>();

        operand = new Operand(stack);
        adder = new Adder(stack);
        resultPresenter = new ResultPresenter(stack);
        calculator = new CalculatorGui(operand, adder, resultPresenter);
    }
}
