package gui;

import javax.swing.JPanel;

public class DigitButton extends CalculatorButton {
    private int digit;

    DigitButton(int digit,
                int bounds[],
                JPanel panel,
                DigitButtonHandler digitButtonHandler
    ) {
        super(Integer.toString(digit), bounds, panel, digitButtonHandler);

        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }
}
