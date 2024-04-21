package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.OperandIf;

public class DigitButtonHandler implements ActionListener {
    private OperandIf operand;

    public DigitButtonHandler(OperandIf operand) {
        this.operand = operand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        operand.addDigit( (char) ( '0' + ( (DigitButton) e.getSource() ).getDigit() ) );
    }
}
