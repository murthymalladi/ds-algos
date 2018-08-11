package trieNew;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmalladi on 8/9/2018.
 */

class TrieNode {
    char c;
    boolean isWord;
    Map<Character,TrieNode> children;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertWord(String word) {
        char ch;
        Map<Character,TrieNode> children = root.children;
        TrieNode tempNode;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (children.containsKey(ch)) {
               // children = children.get(ch).children;
                tempNode = children.get(ch);
            }
            else {
                tempNode = new TrieNode(ch);
                children.put(ch,tempNode);

            }
            children = tempNode.children;
            if (i == word.length() - 1) {
                tempNode.isWord = true;
            }
        }
    }

    public boolean searchWord(String word) {
        Map<Character,TrieNode> children = root.children;

        char ch;
        TrieNode temp;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (!children.containsKey(ch)) {
                return false;
            }
            temp = children.get(ch);
            children = temp.children;
            if (i == word.length() - 1) {
                if (temp.isWord) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchWordV2(String word) {
        TrieNode trieNode = searchNode(word);
        if (trieNode == null) {
            return false;
        }
        else if (trieNode.isWord) {
            return true;
        }
        else {
            return false;
        }
    }

    public TrieNode searchNode(String word) {
        char ch;
        TrieNode temp = null;
        Map<Character,TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (children.containsKey(ch)) {
                temp = children.get(ch);
                children = temp.children;
            }
            else {
                return null;
            }

        }
        return temp;
    }

    public void printWords() {
        Map<Character,TrieNode> children = root.children;
        for (Map.Entry<Character,TrieNode> entry : children.entrySet()) {
            String result = "";
            printAllWordsUtil(entry.getValue(),result);

        }
    }

    public void printAllWordsUtil(TrieNode node,String result) {
        Map<Character,TrieNode> children = node.children;
        char ch;
        TrieNode tempNode = null;
        result = result + node.c;
        if (node.isWord) {
            System.out.println(result);
        }
        for (Map.Entry<Character,TrieNode> entry : children.entrySet()) {

            tempNode = entry.getValue();

            if (tempNode != null) {
                printAllWordsUtil(tempNode,result);
            }

        }
    }

    public void printAllPrefixWordsUtil(TrieNode node,String result,String prefix) {
        Map<Character,TrieNode> children = node.children;
        char ch;
        TrieNode tempNode = null;
        result = result + node.c;
        if (node.isWord) {
            System.out.println(prefix + result);
        }
        for (Map.Entry<Character,TrieNode> entry : children.entrySet()) {

            tempNode = entry.getValue();

            if (tempNode != null) {
                printAllPrefixWordsUtil(tempNode,result,prefix);
            }

        }
    }

    public void printAllprefixWords(String prefix) {
        TrieNode prefixNode = searchNode(prefix);
        String result = "";
        prefix = prefix.substring(0,prefix.length() - 1);
        printAllPrefixWordsUtil(prefixNode,result,prefix);
    }

}
