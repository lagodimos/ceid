package gui;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorDisplay extends JTextField {
    static Font font = new Font("Arial", Font.PLAIN, 20);
    static Insets margin = new Insets(0, 0, 0, 0);

    public CalculatorDisplay(int bounds[], JPanel panel) {
        super("");
        setFont(font);
        setEditable(false);
        setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);

        panel.add(this);
    }
}
