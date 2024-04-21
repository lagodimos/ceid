package gui;

import javax.swing.JPanel;

public class OperatorButton extends CalculatorButton {
    char symbol;

    public OperatorButton(char symbol,
                          int bounds[],
                          JPanel panel,
                          OperatorButtonHandler operatorButtonHandler
    ) {
        super(Character.toString(symbol), bounds, panel, operatorButtonHandler);

        this.symbol = symbol;
    }

    char getOperation() {
        return symbol;
    }
}
