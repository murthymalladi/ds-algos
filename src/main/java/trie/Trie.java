package trie;

/**
 * Created by dmalladi on 8/6/2018.
 */
public class Trie {
    private TrieContainer head;

    public Trie() {
        head = new TrieContainer();
    }

    public void insertWord(String word) {

        int wordLength = word.length();
        char ch;
        TrieContainer start = head;
        for (int charIndex = 0; charIndex < wordLength; charIndex++) {
            ch = word.charAt(charIndex);
            if (start.getSeries()[ch - 97] != null) {
                if (charIndex == wordLength - 1) {
                    start.getSeries()[ch - 97].setWord(true);
                }
                start = start.getSeries()[ch - 97];
            }
            else {
                TrieContainer container = new TrieContainer();
                if (charIndex == wordLength - 1) {
                    container.setWord(true);
                }
                start.getSeries()[ch - 97] = container;
                start = start.getSeries()[ch - 97];
            }
        }
    }

    public boolean searchWord(String word) {
        TrieContainer start = head;

        int wordLength = word.length();
        char ch;
        for (int charIndex = 0; charIndex < wordLength; charIndex++) {
            ch = word.charAt(charIndex);
            if (start.getSeries()[ch - 97] != null) {
                if (charIndex == wordLength - 1) {
                    if (start.getSeries()[ch - 97].isWord()) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                start = start.getSeries()[ch - 97];
            }
            else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("hello");
        trie.insertWord("hallo");
        trie.insertWord("java");
        trie.insertWord("john");

        String word = "john";
        if (trie.searchWord(word)) {
            System.out.println(word + " is there.");
        }
        else {
            System.out.println(word + " is not in trie.");
        }
    }

    public void printAllWords() {
        TrieContainer start = head;
        printAllWordsUtil(start,"");

    }

    private void printAllWordsUtil(TrieContainer start,String word) {
        
    }
}
