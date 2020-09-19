package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmalladi on 1/19/2020.
 */
public class WordSquare {
    static char[][] grid;
    static Map<String,List<String>> map;

    public static List<List<String>> wordSquares(String[] words) {
        List<List<String>> results = new ArrayList<>();
        if (words.length == 0)
            return results;
        int n = words[0].length();
        int N = words.length;
        grid = new char[N][n];
        map = new HashMap<>();

        //build prefix map
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0,i);
                if (!map.containsKey(prefix)) {
                    map.put(prefix,new ArrayList<>());
                }
                map.get(prefix).add(word);
            }
        }

        List<String> wordGrid = new ArrayList<>();
        for (String word : words) {
            wordGrid.add(word);
            dfs(1,words,wordGrid,results);
            wordGrid.remove(wordGrid.size()-1);
        }
        return results;
    }

    public static void dfs(int step,String[] words,List<String> wordGrid,List<List<String>> results) {
        if (step == words[0].length()) {
            results.add(new ArrayList<>(wordGrid));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String val : wordGrid) {
            sb.append(val.charAt(step));
        }
        String prefix = sb.toString();
        List<String> prefixes = map.get(prefix);
        if (prefixes == null)
            return;
        for (String cand : prefixes) {
            wordGrid.add(cand);
            dfs(step+1,words,wordGrid,results);
            wordGrid.remove(wordGrid.size()-1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"area","lead","wall","lady","ball"};
        List<List<String>> results = wordSquares(words);

        for (List<String> list : results) {
            for (String word : list) {
                System.out.println(word);
            }
            System.out.println();
            System.out.println();
        }
    }



}
