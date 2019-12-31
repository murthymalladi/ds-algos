package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 9/11/2019.
 */
public class LongestSubStringWithSameLetters {

    public static void main(String[] args) {
        String str = "abccde";
        int k = 1;
        int maxLen = findLength(str,k);
        System.out.println(maxLen);
    }

    public static int findLength(String str, int k) {
        if (str.length() == 0)
            return -1;

        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxRepeat = 0;
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            maxRepeat = Math.max(maxRepeat,map.get(c));
            if (end - start+1 - maxRepeat > k) {
                char leftChar = str.charAt(start);
                map.put(leftChar,map.get(leftChar)-1);
                start++;
            }
            maxLen = Math.max(maxLen,end - start + 1);
        }

        if (maxLen == Integer.MIN_VALUE)
          return -1;
        return maxLen;
    }
}
