package binarysignal;

public final class FixedBinaryOutputSignal implements BinaryOutputSignal {
    private boolean signal;

    public FixedBinaryOutputSignal() {
        this.signal = false;
    }

    public FixedBinaryOutputSignal(boolean value) {
        this.signal = value;
    }

    public boolean getSignal() {
        return signal;
    }

    public void setSignal(boolean value) {
        this.signal = value;
    }
}
