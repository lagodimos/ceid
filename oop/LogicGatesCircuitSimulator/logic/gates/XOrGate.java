package logic.gates;

import java.util.ArrayList;

import binarysignal.BinarySignal;

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

    public XOrGate(ArrayList<BinarySignal> inputs) {
        super(inputs);
    }

    public XOrGate(BinarySignal... inputs) {
        super(inputs);
    }

    public void calcOutput() {
        var value = false;

        for (BinarySignal input: inputs) {
            if (input.getSignal()) {
                value = ! value;
            }
        }

        setOutput(value);
    }
}
