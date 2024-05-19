import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class TextStats {
    private Text text;

    private HashMap<String, Integer> wordOccurrences;
    private HashMap<String, ArrayList<Integer>> maxOccurrencesSentences;  // Empty ArrayList if text doesn't contain it

    private HashMap<String, ArrayList<Integer>> idxOfSentencesContainingWords;

    public TextStats(Text text) {
        this.text = text;

        countWordsOccurrences();
        findMaxOccurrencesSentences();
        findIdxOfSentencesContainingWords();
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
            getNumOfSentencesContainingWord(word) + "\n" +

            "Total occurrences in the text: " +
            getWordOccurrences(word) + "\n" +

            "First occurrence in sentence: " +
            (getIdxOfFirstSentenceContainingWord(word) == -1 ? "N/A" :
                getIdxOfFirstSentenceContainingWord(word) + 1
            ) + "\n" +

            "Sentence(s) with most occurrences: " +
            (getWordOccurrences(word) == 0 ? "N/A" :
                getMaxOccurrencesSentencesIdxForWord(word)
                    .stream()
                    .map(num -> num + 1)
                    .collect(Collectors.toCollection(ArrayList::new))
            )
        );
    }

    public void displayForWordForSentence(String word, Integer sentenceIdx) {
        ArrayList<Sentence> sentences = text.getSentences();

        if (sentenceIdx < sentences.size()) {
            var stats = sentences.get(sentenceIdx).getStats();

            System.out.println(
                "\n" +
                "Sentence number: " + (sentenceIdx+1) + "\n" +

                "Occurrences in sentence: " + stats.getWordOccurrences(word) + "\n" +

                "Positions in the sentence: " +
                (stats.getWordPositions(word).isEmpty() ? "N/A" :
                    stats.getWordPositions(word)
                        .stream()
                        .map(num -> num + 1)
                        .collect(Collectors.toCollection(ArrayList::new))
                )
            );
        }
        else System.err.println("No such sentence to display stats for!");
    }

    public int getWordOccurrences(String word) {
        Integer occurrences = wordOccurrences.get(word);
        return occurrences == null ? 0 : occurrences;
    }

    public int getWordOccurrencesInSentence(String word, int sentenceIdx) {
        var sentence = text.getSentences().get(sentenceIdx);
        return sentence.getStats().getWordOccurrences(word);
    }

    public int getNumOfSentencesContainingWord(String word) {
        return idxOfSentencesContainingWords.get(word) == null ? 0 :
               idxOfSentencesContainingWords.get(word).size();
    }

    public int getIdxOfFirstSentenceContainingWord(String word) {
        return idxOfSentencesContainingWords.get(word) == null ? -1 :
               idxOfSentencesContainingWords.get(word).get(0);
    }

    public ArrayList<Integer> getMaxOccurrencesSentencesIdxForWord(String word) {
        return maxOccurrencesSentences.get(word) == null ? new ArrayList<>():
               maxOccurrencesSentences.get(word);
    }

    private void countWordsOccurrences() {
        wordOccurrences = new HashMap<>();

        Set<String> words;

        for (Sentence sentence: text.getSentences()) {
            words = sentence.getStats().getWords();

            for (String word: words) {
                wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + sentence.getStats().getWordOccurrences(word));
            }
        }
    }

    private void findMaxOccurrencesSentences() {
        maxOccurrencesSentences = new HashMap<>();

        int occurrences, maxOccurrences = 0;

        var sentences = text.getSentences();

        for (String word: wordOccurrences.keySet()) {
            maxOccurrencesSentences.put(word, new ArrayList<>());

            for (int i = 0; i < sentences.size(); i++) {

                if ((occurrences = sentences.get(i).getStats().getWordOccurrences(word)) >= maxOccurrences) {
                    if (occurrences > maxOccurrences) {
                        maxOccurrencesSentences.get(word).clear();
                    }

                    maxOccurrences = occurrences;
                    maxOccurrencesSentences.get(word).add(i);
                }
            }

            maxOccurrences = 0;
        }
    }

    private void findIdxOfSentencesContainingWords() {
        idxOfSentencesContainingWords = new HashMap<>();

        var sentences = text.getSentences();

        for (String word: wordOccurrences.keySet()) {
            idxOfSentencesContainingWords.put(word, new ArrayList<>());

            for (int i = 0; i < sentences.size(); i++) {
                if (sentences.get(i).getWordsSequence().contains(word)) {
                    idxOfSentencesContainingWords.get(word).add(i);
                }
            }
        }
    }
}
