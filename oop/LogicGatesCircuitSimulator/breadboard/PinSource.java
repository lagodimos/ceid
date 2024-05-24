package breadboard;

import binarysignal.BinaryOutputSignal;

public class PinSource implements BinaryOutputSignal {
    Pin pin;

    public PinSource(Pin pin) {
        this.pin = pin;
    }

    @Override
    public boolean getSignal() {
        return pin.getSignal();
    }
}
