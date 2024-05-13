import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.Console;

public class TextAnalyzerApp {

    private static final String fileName = "TextAnalyzerSampleFile2.txt";

    private static Text text;
    private static String textStr;

    private static String word;
    private static ArrayList<Sentence> sentences;

    public static void main(String[] args) {

        try {
            textStr = new String(Files.readAllBytes(Paths.get(fileName)));
        }
        catch (IOException e) {
            System.err.println("Cannot read file: " + fileName);
        }

        text = new Text(textStr);
        sentences = text.getSentences();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a word: ");
        word = scanner.nextLine();

        System.out.println(
            "\n" +
            "=== Stats for whole text ===" + "\n" +

            "Number of sentences it appears in: " +
            text.getNumOfSentencesContainingWord(word) + "\n" +

            "Total occurrences in the text: " +
            text.getWordOccurrences(word) + "\n" +

            "First occurrence in sentence: " +
            (text.getIdxOfFirstSentenceContainingWord(word) == -1 ? "N/A" :
                text.getIdxOfFirstSentenceContainingWord(word)
            ) + "\n" +

            "Sentence(s) with most occurrences: " +
            (text.getWordOccurrences(word) == 0 ? "N/A" :
                text.getMaxOccurrencesSentencesIdxForWord(word)
                    .stream()
                    .map(num -> num + 1)
                    .collect(Collectors.toCollection(ArrayList::new))
            ) + "\n" +

            "\n=== Stats for each sentence ==="
        );

        for (int i = 0; i < sentences.size(); i++) {
            System.out.println(
                "\n" +
                "Sentence number: " + (i+1) + "\n" +

                "Occurrences in sentence: " + sentences.get(i).getWordOccurrences(word) + "\n" +

                "Positions in the sentence: " +
                (sentences.get(i).getWordPositions(word).isEmpty() ? "N/A" :
                    sentences.get(i).getWordPositions(word)
                        .stream()
                        .map(num -> num + 1)
                        .collect(Collectors.toCollection(ArrayList::new))
                )
            );
        }

        scanner.close();
    }
}
