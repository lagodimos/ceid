package circuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import binarysignal.*;
import breadboard.BreadBoard;
import logic.gates.*;
import logic.symbols.LogicSymbols;

public class Circuit {
    private BreadBoard breadboard;
    private ArrayList< ArrayList<String> > statements;

    public Circuit(String s) {
        parseText(s);
        evalStatements();
    }

    public void askForInputs(Scanner scanner) {
        System.out.println("\nInsert inputs:");

        for (int i=1; i<=breadboard.getRows(); i++) {
            var value = scanner.nextLine().toLowerCase();

            breadboard.setPinSource(i, 1,
                new FixedBinaryOutputSignal(
                    LogicSymbols.getSymbols(true).contains(value)
                )
            );
        }
    }

    public void displayOutputs() {
        System.out.println("\nOutputs:");
        for (int i=1; i<=breadboard.getRows(); i++) {
            System.out.println(
                breadboard.getPinSource(i, breadboard.getColumns()).getSignal() ? "HIGH" : "LOW"
            );
        }
    }

    private void parseText(String s) {
        statements = new ArrayList< ArrayList<String> >();

        for (String line: s.split("\n", 0)) {
            if (! line.isBlank() && ! line.startsWith("#")) {
                statements.add(
                    new ArrayList<>(Arrays.asList(line.split(" ")))
                );
            }
        }
    }

    private void evalStatements() {
        for (ArrayList<String> statement: statements) {
            final var gate_types = Arrays.asList(
                "not", "and", "nand", "or", "nor", "xor", "xnor"
            );

            // BreadBoard
            if (statement.get(0).toLowerCase().equals("breadboard")) {
                breadboard = new BreadBoard(
                    Integer.parseInt(statement.get(1)),
                    Integer.parseInt(statement.get(2))
                );
            }
            // Gate
            else if (gate_types.contains(statement.get(0).toLowerCase())) {
                LogicGate gate;

                switch (statement.get(0).toLowerCase()) {
                    case "not":
                        gate = new NotGate();
                        break;
                    case "and":
                        gate = new AndGate();
                        break;
                    case "nand":
                        gate = new NandGate();
                        break;
                    case "or":
                        gate = new OrGate();
                        break;
                    case "nor":
                        gate = new NOrGate();
                        break;
                    case "xor":
                        gate = new XOrGate();
                        break;
                    case "xnor":
                        gate = new XNOrGate();
                        break;
                    default:
                        gate = new NotGate();   // Just to give a default initialization
                }

                var column = Integer.parseInt(statement.get(1));

                if (!statement.get(0).toLowerCase().equals("not")) {
                    gate.setInputs(
                        breadboard.getPinSource(Integer.parseInt(statement.get(2)), column),
                        breadboard.getPinSource(Integer.parseInt(statement.get(3)), column)
                    );
                }

                breadboard.setPinSource(Integer.parseInt(statement.get(4)), column + 1, gate);
            }
        }
    }
}
