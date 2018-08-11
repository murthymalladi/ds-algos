package trieNew;

/**
 * Created by dmalladi on 8/9/2018.
 */
public class TrieDemo {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("hello");
        trie.insertWord("hell");
        trie.insertWord("compute");
        trie.insertWord("computer");
        trie.insertWord("computers");
        trie.insertWord("computerize");
        trie.insertWord("computerization");
        trie.insertWord("computation");
        trie.insertWord("computations");
        trie.insertWord("Zebra");
        trie.insertWord("apple");

//        String word = "compute";
//        if (trie.searchWordV2(word)) {
//            System.out.println(word + " found");
//        }
//        else {
//            System.out.println(word + " not found");
//        }

        System.out.println("print the words: ");
        trie.printWords();
        String prefix = "comput";
        System.out.println("\n\n the prefix words with the prefix " + prefix);
        trie.printAllprefixWords(prefix);
    }
}
