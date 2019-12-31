package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 9/10/2019.
 */
public class LongestSubstringWithKdistinctChars {

    public static void main(String[] args) {
        String str="cbbebi";
        int K=3;

        int maxLen = findLength(str,K);
        System.out.println(maxLen);
    }

    public static int findLength(String str, int k) {

        if (str.length() == 0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();

        int start = 0;
        int maxLen = Integer.MIN_VALUE;

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.size() > k) {
                c = str.charAt(start);
                map.put(c,map.get(c)-1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                start++;
            }
            maxLen = Math.max(maxLen,end - start +1);
        }
        if (maxLen == Integer.MIN_VALUE)
            return -1;
        return maxLen;
    }
}
