package binarysignal;

public final class FixedBinarySignal implements BinarySignal {
    private boolean signal;

    public FixedBinarySignal() {
        this.signal = false;
    }

    public FixedBinarySignal(boolean value) {
        this.signal = value;
    }

    public boolean getSignal() {
        return signal;
    }

    public void setSignal(boolean value) {
        this.signal = value;
    }
}
