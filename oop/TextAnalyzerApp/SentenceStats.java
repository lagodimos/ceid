import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SentenceStats {
    private Sentence sentence;

    private HashMap<String, ArrayList<Integer>> wordPositions;

    public SentenceStats(Sentence sentence) {
        this.sentence = sentence;
        findWordsIndexes();
    }

    public Set<String> getWords() {
        return wordPositions.keySet();
    }

    public int getWordOccurrences(String word) {
        return getWordPositions(word).size();
    }

    public ArrayList<Integer> getWordPositions(String word) {
        return wordPositions.getOrDefault(word, new ArrayList<>());
    }

    private void findWordsIndexes() {
        var words = sentence.getWordsSequence();
        wordPositions = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            if (!wordPositions.containsKey(words.get(i))) {
                wordPositions.put(words.get(i), new ArrayList<Integer>());
            }
            wordPositions.get(words.get(i)).add(i);
        }
    }
}
