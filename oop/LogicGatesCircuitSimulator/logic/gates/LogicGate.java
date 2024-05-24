package logic.gates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import binarysignal.BinaryOutputSignal;
import binarysignal.FixedBinaryOutputSignal;

public abstract class LogicGate implements BinaryOutputSignal {
    protected boolean output;
    protected Integer inputsNum;
    protected ArrayList<BinaryOutputSignal> inputs;

    public LogicGate(Integer inputsNum) {
        this(inputsNum, false);
    }

    public LogicGate(Integer inputsNum, boolean defaultInputsValue) {
        this.inputsNum = inputsNum;
        inputs = new ArrayList<>();

        for (int i = 0; i < inputsNum; i++) {
            inputs.add(new FixedBinaryOutputSignal(defaultInputsValue));
        }

        calcOutput();
    }

    public LogicGate(BinaryOutputSignal... inputs) {
        this.inputsNum = inputs.length;
        this.inputs = new ArrayList<>();

        for (int i = 0; i < inputsNum; i++) {
            this.inputs.add(inputs[i]);
        }

        calcOutput();
    }

    LogicGate(ArrayList<BinaryOutputSignal> inputs) {
        this(inputs.size());
        this.setInputs(inputs);
    }

    public boolean getSignal() {
        calcOutput();
        return output;
    }

    public void setInputs(ArrayList<BinaryOutputSignal> inputs) {
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

    public void setInputs(BinaryOutputSignal... inputs) {
        setInputs(new ArrayList<>(Arrays.asList(inputs)));
    }

    protected void setOutput(boolean output) {
        this.output = output;
    }

    protected abstract void calcOutput();
}
