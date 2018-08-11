package trie;

/**
 * Created by dmalladi on 8/6/2018.
 */
public class TrieContainer {
    private boolean isWord;
    private TrieContainer[] series;

    public TrieContainer() {
        isWord = false;
        series = new TrieContainer[26];
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public TrieContainer[] getSeries() {
        return series;
    }

    public void setSeries(TrieContainer[] series) {
        this.series = series;
    }
}
