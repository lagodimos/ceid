package breadboard;

import binarysignal.BinaryOutputSignal;

public class Pin implements BinaryOutputSignal {
    BinaryOutputSignal source;

    public Pin() {

    }

    public Pin(BinaryOutputSignal source) {
        this.source = source;
    }

    void setSource(BinaryOutputSignal source) {
        this.source = source;
    }

    public boolean getSignal() {
        if (source != null) {
            return source.getSignal();
        }
        else {
            return false;
        }
    }
}
