package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import operators.Operator;

public class OperatorButtonHandler implements ActionListener {

    Operator adder, subtractor, multiplier, divider, resultPresenter;

    public OperatorButtonHandler(Operator adder,
                                 Operator subtractor,
                                 Operator multiplier,
                                 Operator divider,
                                 Operator resultPresenter
    ) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
        this.resultPresenter = resultPresenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (( (OperatorButton) e.getSource() ).getOperation()) {
            case '+':
                adder.operate();
                break;
            case '-':
                subtractor.operate();
                break;
            case '\u00D7':
                multiplier.operate();
                break;
            case '\u00F7':
                divider.operate();
                break;
            case '=':
                resultPresenter.operate();
                break;
        }
    }
}
