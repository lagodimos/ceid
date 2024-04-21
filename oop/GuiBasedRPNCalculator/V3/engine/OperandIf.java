package engine;

import javax.swing.JTextField;

public interface OperandIf {
    public void addDigit(char digit);
    public void deleteLastDigit();
    public void complete();
    public void reset();
    public void clearEntry();

    public void setDisplay(JTextField display);
}
