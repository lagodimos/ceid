import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextAnalyzerApp {

    private static Scanner scanner = new Scanner(System.in);

    private static final String fileName = "TextAnalyzerSampleFile2.txt";

    private static TextStats stats;
    private static String textStr;

    private static String word;

    public static void main(String[] args) {

        try {
            textStr = new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (IOException e) {
            System.err.println("Cannot read file: " + fileName);
        }

        stats = new TextStats(new Text(textStr));

        System.out.print("Type a word: ");
        word = scanner.nextLine();
        scanner.close();

        stats.displayAllForWord(word);
    }
}
