package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 9/13/2019.
 */
public class SmallestWindowContainingSubString {

    public static void main(String[] args) {
        String str = "abdabca";
        String pattern = "abc";

        String minString = findSubstring(str,pattern);
        System.out.println(minString);
    }

    public static String findSubstring(String str, String pattern) {
        if (str.length() == 0 || pattern.length() == 0)
               return "";

        int start = 0;
        int count = 0;
        int minStart = 0;
        int minEnd = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (Character ch : pattern.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);
            if (map.containsKey(rightChar)) {
                map.put(rightChar,map.get(rightChar)-1);
                if (map.get(rightChar) == 0)
                    count++;
            }
            while(count == pattern.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                    minEnd = end;
                }
                char leftChar = str.charAt(start);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                        count--;
                    map.put(leftChar,map.get(leftChar)+1);

                }
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return str.substring(minStart,minStart + minLen);
    }
}
