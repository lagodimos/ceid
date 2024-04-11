package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.*;
import operators.*;

public class CalculatorGui implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private Font font;

    private OperandIf operand;
    private Operator adder, subtractor, multiplier, divider;
    private ResultPresenter resultPresenter;

    private JButton button0, button1, button2, button3, button4,
                    button5, button6, button7, button8, button9;

    private JButton buttonAdd, buttonSub, buttonMul, buttonDiv;

    private JButton buttonEnter, buttonClear, buttonClearEntry, buttonEquals, buttonBackSpace;

    private JTextField textField;

    public CalculatorGui (
        OperandIf operand,
        Operator adder,
        Operator subtractor,
        Operator multiplier,
        Operator divider,
        ResultPresenter resultPresenter
    ) {
        this.operand = operand;
        this.adder = adder;
        this.subtractor =  subtractor;
        this.multiplier = multiplier;
        this.divider = divider;
        this.resultPresenter = resultPresenter;

        font = new Font("Arial", Font.PLAIN, 20);

        frame = new JFrame("RPN Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280,300);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        button0 = ComponentCreator.JButton("0", font, this, "0");
        button1 = ComponentCreator.JButton("1", font, this, "1");
        button2 = ComponentCreator.JButton("2", font, this, "2");
        button3 = ComponentCreator.JButton("3", font, this, "3");
        button4 = ComponentCreator.JButton("4", font, this, "4");
        button5 = ComponentCreator.JButton("5", font, this, "5");
        button6 = ComponentCreator.JButton("6", font, this, "6");
        button7 = ComponentCreator.JButton("7", font, this, "7");
        button8 = ComponentCreator.JButton("8", font, this, "8");
        button9 = ComponentCreator.JButton("9", font, this, "9");
        buttonAdd = ComponentCreator.JButton("+", font, this, "add");
        buttonSub = ComponentCreator.JButton("-", font, this, "sub");
        buttonMul = ComponentCreator.JButton("\u00D7", font, this, "mul");
        buttonDiv = ComponentCreator.JButton("\u00F7", font, this, "div");
        buttonEnter = ComponentCreator.JButton("Enter", font, this, "enter");
        buttonClear = ComponentCreator.JButton("C", font, this, "clear");
        buttonClearEntry = ComponentCreator.JButton("CE", font, this, "clear_entry");
        buttonBackSpace = ComponentCreator.JButton("\u232B", font, this, "backspace");
        buttonEquals = ComponentCreator.JButton("=", font, this, "equals");

        textField = new JTextField("0");
        textField.setEditable(false);
        textField.setFont(font);
        textField.setBounds(10, 10, 260, 40);;

        button7.setBounds(10, 60, 40, 40);
        button4.setBounds(10, 110, 40, 40);
        button1.setBounds(10, 160, 40, 40);
        button0.setBounds(10, 210, 40, 40);
        //---
        button8.setBounds(65, 60, 40, 40);
        button5.setBounds(65, 110, 40, 40);
        button2.setBounds(65, 160, 40, 40);
        //---
        button9.setBounds(120, 60, 40, 40);
        button6.setBounds(120, 110, 40, 40);
        button3.setBounds(120, 160, 40, 40);
        //---
        buttonDiv.setBounds(175, 60, 40, 40);
        buttonMul.setBounds(175, 110, 40, 40);
        buttonSub.setBounds(175, 160, 40, 40);
        buttonAdd.setBounds(175, 210, 40, 40);
        buttonEnter.setBounds(65, 210, 95, 40);
        //---
        buttonClear.setBounds(230, 60, 40, 40);
        buttonClearEntry.setBounds(230, 110, 40, 40);
        buttonBackSpace.setBounds(230, 160, 40, 40);
        buttonEquals.setBounds(230, 210, 40, 40);

        var buttons = new JButton[] {
            button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonAdd, buttonSub, buttonMul, buttonDiv,
            buttonEnter, buttonClear, buttonClearEntry, buttonEquals, buttonBackSpace
        };

        for (JButton jButton : buttons) {
            panel.add(jButton);
        }

        panel.add(textField);

        frame.toFront();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                operand.addDigit(e.getActionCommand().toCharArray()[0]);
                break;
            case "add":
                adder.operate();
                break;
            case "sub":
                subtractor.operate();
                break;
            case "mul":
                multiplier.operate();
                break;
            case "div":
                divider.operate();
                break;
            case "enter":
                operand.complete();
                break;
            case "clear":
                operand.reset();
                break;
            case "clear_entry":
                operand.clearEntry();
                break;
            case "backspace":
                operand.deleteLastDigit();
                break;
            case "equals":
                textField.setText(resultPresenter.operate().toString());
                break;
        }
    }
}
