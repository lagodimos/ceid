package BinarySignal;

public class FixedBinarySignal implements BinarySignal {
    boolean signal;

    public FixedBinarySignal() {
        this.signal = false;
    }

    public FixedBinarySignal(boolean value) {
        this.signal = value;
    }

    public boolean getValue() {
        return signal;
    }
    public void setSignalValue(boolean value) {
        this.signal = value;
    }
}
