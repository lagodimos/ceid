import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
    private String sentence;
    private ArrayList<String> words;

    private SentenceStats stats;

    public Sentence(String sentence) {
        this.sentence = sentence;
        parseSentence();

        stats = new SentenceStats(this);
    }

    public ArrayList<String> getWordsSequence() {
        var wordsCopy = new ArrayList<String>();
        wordsCopy.addAll(words);

        return wordsCopy;
    }

    public SentenceStats getStats() {
        return stats;
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
}
