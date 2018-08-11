package stringAlgorithms;

import java.util.*;

/**
 * @author dmalladi
 */
public class WordLadder {

    public static void main(String[] args) {

        String start = "hit";
        String end  = "cog";
        Set<String> dict = new HashSet<String>();
                    dict.add("hot");
                    dict.add("dot");
                    dict.add("dog");
                    dict.add("cog");

     //   int count = ladderCount(start,end,dict);
     //   System.out.println(count);

        System.out.println("v2: " + ladderCountV2(start,end,dict));

    }

    private static class WordNode {
        String Word;
        int numSteps;
        public WordNode(String word,int numSteps) {
            this.Word = word;
            this.numSteps = numSteps;
        }
    }

    public static int ladderCount(String startWord,String endWord,Set<String> wordDict) {

       // char[] arr = startWord.toCharArray();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(startWord,1));

        wordDict.add(endWord);
        WordNode wordNode = null;

        while (!queue.isEmpty()) {
            wordNode = queue.remove();
            String word = wordNode.Word;
            if (word.equals(endWord)) {
                return wordNode.numSteps;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char ch = arr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (ch == j) {
                        continue;
                    }
                    arr[i] = j;

                    String newWord = String.valueOf(arr);
                    if (wordDict.contains(newWord)) {
                        queue.add(new WordNode(newWord,wordNode.numSteps+1));
                        wordDict.remove(newWord);
                    }
                }
                arr[i] = ch;

            }
        }

        return 0;
    }

    public static int ladderCountV2(String startWord,String endWord,Set<String> wordDict) {

        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.offer(new WordNode(startWord,1));
        WordNode wordNode = null;
        while(!queue.isEmpty()) {
            wordNode = queue.remove();
            for (String dictToken: wordDict) {
                if (isAdjacent(wordNode.Word,dictToken)) {
                    if (endWord.equals(dictToken)) {
                        return wordNode.numSteps + 1;
                    }
                    queue.offer(new WordNode(dictToken,wordNode.numSteps+1));
                  //  wordDict.remove(dictToken);
                }
            }
        }
        return 0;
    }

    public static boolean isAdjacent(String source,String target) {

        char[] a = source.toCharArray();
        char[] b = target.toCharArray();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) count++;
            if (count > 1)
                return false;
        }
        if (count > 1)
            return false;
        return true;
    }
}
