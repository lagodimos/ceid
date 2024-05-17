package logic.gates;

import binarysignal.BinaryOutputSignal;

public class NotGate extends LogicGate {

    public NotGate() {
        super(1);
    }

    public NotGate(boolean inputValue) {
        super(1, inputValue);
    }

    public NotGate(BinaryOutputSignal input) {
        super(input);
    }

    public void calcOutput() {
        setOutput(!inputs.get(0).getSignal());
    }
}
