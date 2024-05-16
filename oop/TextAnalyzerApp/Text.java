import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Text {
    private String text;

    private ArrayList<String> sentencesStr;
    private ArrayList<Sentence> sentences;

    private HashMap<String, Integer> wordOccurrences;
    private HashMap<String, ArrayList<Integer>> maxOccurrencesSentences;  // Empty ArrayList if text doesn't contain it

    private HashMap<String, ArrayList<Integer>> idxOfSentencesContainingWords;

    public Text(String text) {
        this.text = text;

        parseText();
        countWordsOccurrences();
        findMaxOccurrencesSentences();
        findIdxOfSentencesContainingWords();
    }

    public String getText() {
        return text;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public int getWordOccurrences(String word) {
        Integer occurrences = wordOccurrences.get(word);
        return occurrences == null ? 0 : occurrences;
    }

    public int getWordOccurrencesInSentence(String word, int sentenceIdx) {
        return sentences.get(sentenceIdx).getWordOccurrences(word);
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

    private void parseText() {
        this.sentences = new ArrayList<>();
        this.sentencesStr = new ArrayList<>(Arrays.asList(text.split("(?<=\\.)\\s+", 0)));

        for (String str: sentencesStr) {
            sentences.add(new Sentence(str));
        }
    }

    private void countWordsOccurrences() {
        wordOccurrences = new HashMap<>();

        Set<String> words;

        for (Sentence sentence: sentences) {
            words = sentence.getWords();

            for (String word: words) {
                wordOccurrences.put(word, wordOccurrences.getOrDefault(word, 0) + sentence.getWordOccurrences(word));
            }
        }
    }

    private void findMaxOccurrencesSentences() {
        maxOccurrencesSentences = new HashMap<>();

        int occurrences, maxOccurrences = 0;

        for (String word: wordOccurrences.keySet()) {
            maxOccurrencesSentences.put(word, new ArrayList<>());

            for (int i = 0; i < sentences.size(); i++) {

                if ((occurrences = sentences.get(i).getWordOccurrences(word)) >= maxOccurrences) {
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

        for (String word: wordOccurrences.keySet()) {
            idxOfSentencesContainingWords.put(word, new ArrayList<>());

            for (int i = 0; i < sentences.size(); i++) {
                if (sentences.get(i).containsWord(word)) {
                    idxOfSentencesContainingWords.get(word).add(i);
                }
            }
        }
    }
}
