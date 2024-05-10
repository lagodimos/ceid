package logic.gates;

import java.util.ArrayList;

import binarysignal.BinarySignal;

public class NOrGate extends LogicGate {

    public NOrGate() {
        super(2);
    }

    public NOrGate(Integer inputsNum) {
        super(inputsNum);
    }

    public NOrGate(Integer inputsNum, boolean defaultInputsValue) {
        super(inputsNum, defaultInputsValue);
    }

    public NOrGate(ArrayList<BinarySignal> inputs) {
        super(inputs);
    }

    public NOrGate(BinarySignal... inputs) {
        super(inputs);
    }

    public void calcOutput() {
        var value = true;
        var i = 0;

        while (i < inputsNum && value) {
            value = ! inputs.get(i++).getValue();
        }

        setOutput(value);
    }
}
