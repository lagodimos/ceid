import java.util.ArrayList;
import java.util.Arrays;

public class Text {
    private String text;

    private ArrayList<String> sentencesStr;
    private ArrayList<Sentence> sentences;

    private TextStats stats;

    public Text(String text) {
        this.text = text;
        parseText();

        stats = new TextStats(this);
    }

    public String getText() {
        return text;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public TextStats getStats() {
        return stats;
    }

    private void parseText() {
        this.sentences = new ArrayList<>();
        this.sentencesStr = new ArrayList<>(Arrays.asList(text.split("(?<=\\.)\\s+", 0)));

        for (String str: sentencesStr) {
            sentences.add(new Sentence(str));
        }
    }
}
