import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Sentence {
    private String sentence;
    private ArrayList<String> words;

    private HashMap<String, ArrayList<Integer>> wordPositions;

    public Sentence(String sentence) {
        this.sentence = sentence;

        parseSentence();
        findWordsIndexes();
    }

    public Set<String> getWords() {
        return wordPositions.keySet();
    }

    public boolean containsWord(String word) {
        boolean isFound = false;
        var wordsItr = words.iterator();

        while (wordsItr.hasNext() && ! isFound) {
            if (wordsItr.next().equals(word)) {
                isFound = true;
            }
        }

        return isFound;
    }

    public int getWordOccurrences(String word) {
        return getWordPositions(word).size();
    }

    public ArrayList<Integer> getWordPositions(String word) {
        return wordPositions.getOrDefault(word, new ArrayList<>());
    }

    @Override
    public String toString() {
        return sentence;
    }

    private void parseSentence() {
        words = new ArrayList<>(
            Arrays.asList(sentence.split("\\W+", 0))
        );
    }

    private void findWordsIndexes() {
        wordPositions = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            if (!wordPositions.containsKey(words.get(i))) {
                wordPositions.put(words.get(i), new ArrayList<Integer>());
            }
            wordPositions.get(words.get(i)).add(i);
        }
    }
}
