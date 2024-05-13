import java.util.ArrayList;
import java.util.stream.Collectors;

public class TextStats {

    private Text text;

    public TextStats(Text text) {
        this.text = text;
    }

    public void displayAllForWord(String word) {

        System.out.println("\n=== Stats for whole text ===\n");
        displayForWord(word);

        System.out.println("\n=== Stats for each sentence ===");
        for (int i = 0; i < text.getSentences().size(); i++) {
            displayForWordForSentence(word, i);
        }
    }

    public void displayForWord(String word) {

        System.out.println(
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
            )
        );
    }

    public void displayForWordForSentence(String word, Integer sentenceIdx) {

        ArrayList<Sentence> sentences = text.getSentences();

        if (sentenceIdx < sentences.size()) {
            System.out.println(
                "\n" +
                "Sentence number: " + (sentenceIdx+1) + "\n" +

                "Occurrences in sentence: " + sentences.get(sentenceIdx).getWordOccurrences(word) + "\n" +

                "Positions in the sentence: " +
                (sentences.get(sentenceIdx).getWordPositions(word).isEmpty() ? "N/A" :
                    sentences.get(sentenceIdx).getWordPositions(word)
                        .stream()
                        .map(num -> num + 1)
                        .collect(Collectors.toCollection(ArrayList::new))
                )
            );
        }
        else System.err.println("No such sentence to display stats for!");
    }
}
