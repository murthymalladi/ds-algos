package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmalladi on 5/8/2019.
 */
public class LongestSubStringWithAtmostKUniqueChars {
    public static void main(String[] args) {
        String s = "aaabbb";
        int k = 3;
        int res = longestSubstringV2(s,k);
        System.out.println(res);
    }
    public static int longestSubstringV2(String s,int k) {
        Map<Character,Integer> map = new HashMap<>();
        int start=0,end=0;
        int len = Integer.MIN_VALUE;
        int counter=0;
        while(end < s.length()) {
            char c = s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            if (map.get(c) == 1) counter++;
            end++;
            if (counter == k)
                len = Math.max(len,end-start);
            while(counter > k) {
                char tempC = s.charAt(start);
                map.put(tempC,map.get(tempC)-1);
                if (map.get(tempC) == 0) {
                    counter--;
                }

                start++;
            }
        }
        if (len == Integer.MIN_VALUE)
            return 0;
        return len;
    }
}
