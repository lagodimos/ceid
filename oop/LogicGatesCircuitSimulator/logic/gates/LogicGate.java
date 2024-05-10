package logic.gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import binarysignal.BinarySignal;
import binarysignal.FixedBinarySignal;

public abstract class LogicGate implements BinarySignal {
    protected boolean output;
    protected Integer inputsNum;
    protected ArrayList<BinarySignal> inputs;

    public LogicGate(Integer inputsNum) {
        this(inputsNum, false);
    }

    public LogicGate(Integer inputsNum, boolean defaultInputsValue) {
        this.inputsNum = inputsNum;
        inputs = new ArrayList<>();

        for (int i = 0; i < inputsNum; i++) {
            inputs.add(new FixedBinarySignal(defaultInputsValue));
        }

        calcOutput();
    }

    public LogicGate(BinarySignal... inputs) {
        this.inputsNum = inputs.length;
        this.inputs = new ArrayList<>();

        for (int i = 0; i < inputsNum; i++) {
            this.inputs.add(inputs[i]);
        }

        calcOutput();
    }

    LogicGate(ArrayList<BinarySignal> inputs) {
        this(inputs.size());
        this.setInputs(inputs);
    }

    public boolean getValue() {
        return output;
    }

    public void setInputs(ArrayList<BinarySignal> inputs) {
        if (
            inputs != null &&
            inputs.size() == inputsNum &&
            inputs.stream().allMatch(Objects::nonNull)
        ) {
            this.inputs = inputs;
        }
        else {
            System.out.println("Invalid logic gate inputs");
        }

        calcOutput();
    }

    public void setInputs(BinarySignal... inputs) {
        setInputs(new ArrayList<>(Arrays.asList(inputs)));
    }

    protected void setOutput(boolean output) {
        this.output = output;
    }

    protected abstract void calcOutput();
}
