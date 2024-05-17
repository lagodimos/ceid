package logic.gates;

import binarysignal.BinarySignal;

public class NotGate extends LogicGate {

    public NotGate() {
        super(1);
    }

    public NotGate(boolean inputValue) {
        super(1, inputValue);
    }

    public NotGate(BinarySignal input) {
        super(input);
    }

    public void calcOutput() {
        setOutput(!inputs.get(0).getSignal());
    }
}
