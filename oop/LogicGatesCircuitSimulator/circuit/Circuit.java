package circuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import binarysignal.*;
import breadboard.Breadboard;
import logic.gates.*;
import logic.symbols.LogicSymbols;

public class Circuit {
    private ArrayList< ArrayList<String> > statements;

    private HashMap<String, BinarySignal> elements;
    private HashMap<String, BinarySignal> outputs;

    private enum StatementType {
        INPUT,
        GATE,
        OUTPUT;
    }

    public Circuit(String s) {
        new Breadboard(5, 8);

        parseText(s);
        evalStatements();
    }

    public void displayOutputs() {
        for (String output: outputs.keySet()) {
            System.out.println();
            System.out.println(output + " -> " + outputs.get(output).getSignal());
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

        elements = new HashMap<>();
        outputs = new HashMap<>();

        StatementType statementType;
        String elementName;

        String gateType;
        ArrayList<String> gateInputSymbols;
        ArrayList<BinarySignal> gateInputs;

        for (ArrayList<String> statement: this.statements) {

            statementType = identifyStatementType(statement);
            elementName = statement.getFirst();

            if (statementType != StatementType.OUTPUT && elements.containsKey(elementName)) {
                System.out.println("Name " + elementName + " is used for more than one elements");
            }

            switch (statementType) {
                case INPUT:
                    elements.put(elementName,
                        new FixedBinarySignal(
                            LogicSymbols.getSymbols(true).contains(
                                statement.get(1).toLowerCase()
                            )
                        )
                    );
                    break;
                case GATE:

                    gateInputSymbols = new ArrayList<String>(statement.subList(2, statement.size()));
                    gateInputs = new ArrayList<>();
                    gateType = statement.get(1).toLowerCase();

                    for (String inputSymbol: gateInputSymbols) {
                        gateInputs.add(elements.get(inputSymbol));
                    }

                    switch (gateType) {
                        case "not":
                            elements.put(elementName, new NotGate(gateInputs.get(0)));
                            break;
                        case "and":
                            elements.put(elementName, new AndGate(gateInputs));
                            break;
                        case "nand":
                            elements.put(elementName, new NandGate(gateInputs));
                            break;
                        case "or":
                            elements.put(elementName, new OrGate(gateInputs));
                            break;
                        case "nor":
                            elements.put(elementName, new NOrGate(gateInputs));
                            break;
                        case "xor":
                            elements.put(elementName, new XOrGate(gateInputs));
                            break;
                        case "xnor":
                            elements.put(elementName, new XNOrGate(gateInputs));
                            break;
                    }

                    break;
                case OUTPUT:
                    outputs.put(elementName, elements.get(elementName));
                    break;
            }
        }
    }

    private StatementType identifyStatementType(ArrayList<String> statement) {
        StatementType type;

        if (statement.size() == 1) {
            type = StatementType.OUTPUT;
        }
        else if (statement.size() == 2 && LogicSymbols.getSymbols().contains(
                    statement.get(1).toLowerCase()
                 )
        ) {
            type = StatementType.INPUT;
        }
        else type = StatementType.GATE;

        return type;
    }
}
