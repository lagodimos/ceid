package logic.gates;

import java.util.ArrayList;

import binarysignal.BinaryOutputSignal;

public class XOrGate extends LogicGate {

    public XOrGate() {
        super(2);
    }

    public XOrGate(Integer inputsNum) {
        super(inputsNum);
    }

    public XOrGate(Integer inputsNum, boolean defaultInputsValue) {
        super(inputsNum, defaultInputsValue);
    }

    public XOrGate(ArrayList<BinaryOutputSignal> inputs) {
        super(inputs);
    }

    public XOrGate(BinaryOutputSignal... inputs) {
        super(inputs);
    }

    public void calcOutput() {
        var value = false;

        for (BinaryOutputSignal input: inputs) {
            if (input.getSignal()) {
                value = ! value;
            }
        }

        setOutput(value);
    }
}
