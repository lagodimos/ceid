package logic.symbols;

import java.util.ArrayList;
import java.util.Arrays;

public class LogicSymbols {
    private static final ArrayList<String> low = new ArrayList<>(Arrays.asList("low", "l", "false", "0"));
    private static final ArrayList<String> high = new ArrayList<>(Arrays.asList("high", "h", "true", "1"));

    public static ArrayList<String> getSymbols() {
        var symbols = new ArrayList<String>();

        symbols.addAll(low);
        symbols.addAll(high);

        return symbols;
    }

    public static ArrayList<String> getSymbols(boolean value) {
        return new ArrayList<>(value ? high : low);
    }
}
