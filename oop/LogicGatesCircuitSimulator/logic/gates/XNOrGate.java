package logic.gates;

import java.util.ArrayList;

import binarysignal.BinaryOutputSignal;

public class XNOrGate extends LogicGate {

    public XNOrGate() {
        super(2);
    }

    public XNOrGate(Integer inputsNum) {
        super(inputsNum);
    }

    public XNOrGate(Integer inputsNum, boolean defaultInputsValue) {
        super(inputsNum, defaultInputsValue);
    }

    public XNOrGate(ArrayList<BinaryOutputSignal> inputs) {
        super(inputs);
    }

    public XNOrGate(BinaryOutputSignal... inputs) {
        super(inputs);
    }

    public void calcOutput() {
        var value = true;

        for (BinaryOutputSignal input: inputs) {
            if (input.getSignal()) {
                value = ! value;
            }
        }

        setOutput(value);
    }
}
