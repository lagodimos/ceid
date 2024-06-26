package logic.gates;

import java.util.ArrayList;

import binarysignal.BinaryOutputSignal;

public class AndGate extends LogicGate {

    public AndGate() {
        super(2);
    }

    public AndGate(Integer inputsNum) {
        super(inputsNum);
    }

    public AndGate(Integer inputsNum, boolean defaultInputsValue) {
        super(inputsNum, defaultInputsValue);
    }

    public AndGate(ArrayList<BinaryOutputSignal> inputs) {
        super(inputs);
    }

    public AndGate(BinaryOutputSignal... inputs) {
        super(inputs);
    }

    public void calcOutput() {
        var value = true;
        var i = 0;

        while (i < inputsNum && value) {
            value = inputs.get(i++).getSignal();
        }

        setOutput(value);
    }
}
