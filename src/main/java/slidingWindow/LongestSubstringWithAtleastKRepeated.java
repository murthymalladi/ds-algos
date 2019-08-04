package slidingWindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 4/7/2019.
 */
public class LongestSubstringWithAtleastKRepeated {

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;

        int res = longestSubstring(s,k);
        System.out.println(res);
    }

//    public static int longestSubstring(String s, int k) {
//        if (s.length() == 0)
//            return 0;
//
//        HashMap<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (map.containsKey(c)) {
//                map.put(c,map.get(c)+1);
//            }
//            else {
//                map.put(c,1);
//            }
//        }
//
//        int start = 0,end = 0,len = Integer.MIN_VALUE;
//
//        while(end < s.length()) {
//            char c = s.charAt(end);
//            if (map.get(c) < k) {
//                len = Math.max(len,longestSubstring(s.substring(start,end),k));
//                start = end + 1;
//            }
//            end++;
//        }
//
//        len = Math.max(len,longestSubstring(s.substring(start),k));
//        if (len == Integer.MIN_VALUE)
//            return 0;
//        return len;
//    }

    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
