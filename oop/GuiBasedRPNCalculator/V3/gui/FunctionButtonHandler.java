package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.OperandIf;

public class FunctionButtonHandler implements ActionListener {
    OperandIf operand;

    public FunctionButtonHandler(OperandIf operand) {
        this.operand = operand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (( (FunctionButton) e.getSource() ).getFunction()) {
            case "Enter":
                operand.complete();
                break;
            case "C":
                operand.reset();
                break;
            case "CE":
                operand.clearEntry();
                break;
            case "\u232B":
                operand.deleteLastDigit();
                break;
        }
    }
}
