package gui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ComponentCreator {
    public static JButton JButton(String text, Font font, ActionListener l, String actionCommand) {
        var button = new JButton(text);
        button.addActionListener(l);
        button.setActionCommand(actionCommand);
        button.setFocusable(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setFont(font);
        return button;
    }
}
