import BinarySignal.*;
import LogicGates.*;

public class LogicGatesCircuitSimulator {
    public static void main(String[] args) {
        var gate = new XNOrGate(
            new FixedBinarySignal(true),
            new FixedBinarySignal(true)
        );


        System.out.println(!gate.getValue());
    }
}
