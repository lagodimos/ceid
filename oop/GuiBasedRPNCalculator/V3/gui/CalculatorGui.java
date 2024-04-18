package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.*;
import operators.*;

public class CalculatorGui extends JFrame {
    private JPanel panel;

    private OperandIf operand;
    private Operator adder, subtractor, multiplier, divider, resultPresenter;

    private JButton digitButtons[];

    private JButton buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEquals;

    private JButton buttonEnter, buttonClear, buttonClearEntry, buttonBackSpace;

    private JTextField display;

    private DigitButtonHandler digitButtonHandler;
    private OperatorButtonHandler operatorButtonHandler;
    private FunctionButtonHandler functionButtonHandler;

    private int digitButtonsBounds[][] = {
        {10, 210, 40, 40},
        {10, 160, 40, 40},
        {65, 160, 40, 40},
        {120, 160, 40, 40},
        {10, 110, 40, 40},
        {65, 110, 40, 40},
        {120, 110, 40, 40},
        {10, 60, 40, 40},
        {65, 60, 40, 40},
        {120, 60, 40, 40}
    };

    private int operatorButtonsBounds[][] = {
        {175, 210, 40, 40}, // Add
        {175, 160, 40, 40}, // Sub
        {175, 110, 40, 40}, // Mul
        {175, 60, 40, 40},  // Div
        {230, 210, 40, 40}  // Equals
    };

    private int functionButtonsBounds[][] = {
        {65, 210, 95, 40},  // Enter
        {230, 60, 40, 40},  // Clear
        {230, 110, 40, 40}, // Clear Entry
        {230, 160, 40, 40}, // BackSpace
    };

    public CalculatorGui (
        OperandIf operand,
        Operator adder,
        Operator subtractor,
        Operator multiplier,
        Operator divider,
        Operator resultPresenter
    ) {
        super("RPN Calculator");

        this.operand = operand;
        this.adder = adder;
        this.subtractor =  subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
        this.resultPresenter = resultPresenter;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280,300);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        // Display

        display = new CalculatorDisplay(new int[] {10, 10, 260, 40}, panel);

        // Digit Buttons

        digitButtons = new DigitButton[10];
        digitButtonHandler = new DigitButtonHandler(operand);

        for (int i=0; i<10; i++) {
            digitButtons[i] = new DigitButton(i, digitButtonsBounds[i], panel, digitButtonHandler);
        }

        // Operator Buttons

        operatorButtonHandler = new OperatorButtonHandler(adder, subtractor, multiplier, divider, resultPresenter);
        buttonAdd = new OperatorButton('+', operatorButtonsBounds[0], panel, operatorButtonHandler);
        buttonSub = new OperatorButton('-', operatorButtonsBounds[1], panel, operatorButtonHandler);
        buttonMul = new OperatorButton('\u00D7', operatorButtonsBounds[2], panel, operatorButtonHandler);
        buttonDiv = new OperatorButton('\u00F7', operatorButtonsBounds[3], panel, operatorButtonHandler);
        buttonEquals = new OperatorButton('=', operatorButtonsBounds[4], panel, operatorButtonHandler);

        // Function Buttons

        functionButtonHandler = new FunctionButtonHandler(operand);
        buttonEnter = new FunctionButton("Enter", functionButtonsBounds[0], panel, functionButtonHandler);
        buttonClear = new FunctionButton("C", functionButtonsBounds[1], panel, functionButtonHandler);
        buttonClearEntry = new FunctionButton("CE", functionButtonsBounds[2], panel, functionButtonHandler);
        buttonBackSpace = new FunctionButton("\u232B", functionButtonsBounds[3], panel, functionButtonHandler);

        toFront();
        setVisible(true);
    }
}
