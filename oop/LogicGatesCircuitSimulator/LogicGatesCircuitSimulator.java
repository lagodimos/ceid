import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import circuit.*;

public class LogicGatesCircuitSimulator {
    private static Console console;

    private static String fileName;

    private static String circuitStr;
    private static Circuit circuit;

    public static void main(String[] args) {
        console = System.console();

        fileName = console.readLine("Type the file path of the circuit file: ");

        if (fileName.isEmpty()) {
            fileName = "circuit_sample.txt";    // Default file
        }

        try {
            circuitStr = new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (IOException e) {
            System.err.println("Cannot read file: " + fileName);
            System.exit(-1);
        }

        circuit = new Circuit(circuitStr);
        circuit.displayOutputs();
    }
}
