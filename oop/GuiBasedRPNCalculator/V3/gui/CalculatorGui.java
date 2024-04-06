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

public class CalculatorGui implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private Font font;

    private Operand operand;
    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;
    private Divider divider;
    private ResultPresenter resultPresenter;

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JButton buttonAdd;
    private JButton buttonSub;
    private JButton buttonMul;
    private JButton buttonDiv;
    private JButton buttonEquals;

    private JButton buttonEnter;
    private JButton buttonBackSpace;
    private JButton buttonClear;

    private JTextField textField;

    public CalculatorGui(Operand operand,
                         Adder adder,
                         Subtractor subtractor,
                         Multiplier multiplier,
                         Divider divider,
                         ResultPresenter resultPresenter)
    {
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
        buttonBackSpace = ComponentCreator.JButton("\u232B", font, this, "backspace");
        buttonClear = ComponentCreator.JButton("C", font, this, "clear");
        buttonEquals = ComponentCreator.JButton("=", font, this, "equals");

        textField = new JTextField("0");
        textField.setEditable(false);
        textField.setFont(font);
        textField.setBounds(10, 10, 260, 40);;

        panel.setLayout(null);

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
        buttonBackSpace.setBounds(230, 110, 40, 40);
        buttonEquals.setBounds(230, 160, 40, 90);

        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonAdd);
        panel.add(buttonSub);
        panel.add(buttonMul);
        panel.add(buttonDiv);
        panel.add(buttonEnter);
        panel.add(buttonBackSpace);
        panel.add(buttonClear);
        panel.add(buttonEquals);
        panel.add(textField);

        frame.add(panel);
        frame.toFront();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "0":
                operand.addDigit('0');
                break;
            case "1":
                operand.addDigit('1');
                break;
            case "2":
                operand.addDigit('2');
                break;
            case "3":
                operand.addDigit('3');
                break;
            case "4":
                operand.addDigit('4');
                break;
            case "5":
                operand.addDigit('5');
                break;
            case "6":
                operand.addDigit('6');
                break;
            case "7":
                operand.addDigit('7');
                break;
            case "8":
                operand.addDigit('8');
                break;
            case "9":
                operand.addDigit('9');
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
            case "backspace":
                operand.deleteLastDigit();
                break;
            case "clear":
                operand.reset();
                break;
            case "equals":
                textField.setText(resultPresenter.operate().toString());
                break;
        }
    }
}
