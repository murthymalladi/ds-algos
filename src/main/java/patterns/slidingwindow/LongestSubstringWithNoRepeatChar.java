package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 9/10/2019.
 */
public class LongestSubstringWithNoRepeatChar {

    public static void main(String[] args) {
        String str = "abccde";
        int max = findLength(str);
        System.out.println(max);
    }

    public static int findLength(String str) {
        if (str.length() == 0)
            return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start,map.get(c)+1);
            }
            maxLen = Math.max(maxLen,end-start+1);
            map.put(c,end);
        }

        if (maxLen == Integer.MIN_VALUE)
          return -1;
        return maxLen;
    }
}
