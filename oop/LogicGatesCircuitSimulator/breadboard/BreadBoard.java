package breadboard;

import binarysignal.BinaryOutputSignal;

public class BreadBoard {
    Integer[] dimensions;
    Pin[][] pins;

    public BreadBoard(int rows, int columns) {
        dimensions = new Integer[] {rows, columns};
        pins = new Pin[dimensions[0]][dimensions[1]];

        for (int i=1; i<=dimensions[0]; i++) {
            for (int j=1; j<=dimensions[1]; j++) {
                pins[i - 1][j - 1] = new Pin();
            }
        }
    }

    public Integer getRows() {
        return dimensions[0];
    }

    public Integer getColumns() {
        return dimensions[1];
    }

    public void setPinSource(int row, int column, BinaryOutputSignal source) {
        pins[row - 1][column -1].setSource(source);
    }

    public BinaryOutputSignal getPinSource(int row, int column) {
        var pin = pins[row - 1][column - 1];
        return new PinSource(pin);
    }
}
