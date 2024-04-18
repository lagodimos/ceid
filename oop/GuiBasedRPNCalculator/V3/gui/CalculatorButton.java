package gui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

public class CalculatorButton extends JButton {
    static Font font = new Font("Arial", Font.PLAIN, 20);
    static Insets margin = new Insets(0, 0, 0, 0);

    public CalculatorButton(String text, int bounds[], JPanel panel, ActionListener actionListener) {
        setText(text);
        setFont(font);
        setMargin(margin);
        setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        setFocusable(false);

        addActionListener(actionListener);

        panel.add(this);
    }
}
