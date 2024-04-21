package gui;

import javax.swing.JPanel;

public class FunctionButton extends CalculatorButton {
    String function;

    public FunctionButton(String function,
                          int bounds[],
                          JPanel panel,
                          FunctionButtonHandler functionButtonHandler
    ) {
        super(function, bounds, panel, functionButtonHandler);

        this.function = function;
    }

    public String getFunction() {
        return function;
    }
}
