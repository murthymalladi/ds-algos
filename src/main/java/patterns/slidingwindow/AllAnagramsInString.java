package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dmalladi on 9/13/2019.
 */
public class AllAnagramsInString {

    public static void main(String[] args) {
        String str = "abbcabc";
        String pattern = "abc";

       List<Integer> indices = findStringAnagrams(str,pattern);
       System.out.println(indices);

    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        if (str.length() == 0 || pattern.length()==0)
            return resultIndices;

        int start = 0;
        int match = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for (char ch : pattern.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            if (map.containsKey(rightChar)) {
                map.put(rightChar,map.get(rightChar)-1);
                if (map.get(rightChar) == 0)
                    match++;
            }
            if (match == map.size()) {
                resultIndices.add(start);

            }
            if (end >= pattern.length() - 1) {
                char leftChar = str.charAt(start);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        match--;
                    map.put(leftChar,map.get(leftChar)+1);

                }
                start++;
            }
        }
        return resultIndices;
    }
}
