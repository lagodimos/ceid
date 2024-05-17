package logic.gates;

import java.util.ArrayList;

import binarysignal.BinaryOutputSignal;

public class OrGate extends LogicGate {

    public OrGate() {
        super(2);
    }

    public OrGate(Integer inputsNum) {
        super(inputsNum);
    }

    public OrGate(Integer inputsNum, boolean defaultInputsValue) {
        super(inputsNum, defaultInputsValue);
    }

    public OrGate(ArrayList<BinaryOutputSignal> inputs) {
        super(inputs);
    }

    public OrGate(BinaryOutputSignal... inputs) {
        super(inputs);
    }

    public void calcOutput() {
        var value = false;
        var i = 0;

        while (i < inputsNum && ! value) {
            value = inputs.get(i++).getSignal();
        }

        setOutput(value);
    }
}
