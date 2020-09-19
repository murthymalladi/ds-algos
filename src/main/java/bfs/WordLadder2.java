package bfs;

import java.util.*;

/**
 * Created by dmalladi on 1/6/2020.
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        int minLen = Integer.MAX_VALUE;
        int len = 0;
        queue.add(beginWord);
        String charString = "abcdefghijklmnopqrstuvwxyz";

        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String word = queue.poll();
                list.add(word);
                for (int i = 0; i < word.length()-1; i++) {
                    for (int j = 0; j < charString.length(); j++) {
                        if (word.charAt(i) != charString.charAt(j)) {
                            String newWord = word.substring(0,i) + charString.charAt(j);
                            if (i < word.length()-1) {
                                newWord += word.substring(i+1);
                            }

                            if (newWord.equals(endWord)) {
                                if (res.size() > 0) {
                                    if (len > minLen) {
                                        return res;
                                    }
                                    else if (len == minLen) {
                                        List<String> newList = new ArrayList<>(list);
                                        newList.add(newWord);
                                        res.add(newList);
                                    }

                                }
                                else {
                                    minLen = Math.min(minLen,len);
                                    List<String> newList = new ArrayList<>(list);
                                    newList.add(newWord);
                                    res.add(newList);
                                }

                            }

                            if (set.contains(newWord)) {
                                queue.add(newWord);
                                set.remove(newWord);
                            }
                        }

                    }
                }
                list.remove(list.size()-1);
            }


        }
        return res;
    }
}
