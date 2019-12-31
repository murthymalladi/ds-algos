package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 9/11/2019.
 */
public class FruitsIntoBasket {

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        int maxLen = findLength(arr);
        System.out.println(maxLen);
    }

    public static int findLength(char[] arr) {

        if (arr.length == 0)
         return -1;

        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<>();

        for (int end = 0; end < arr.length; end++) {
            map.put(arr[end],map.getOrDefault(arr[end],0)+1);
            while (map.size() > 2) {
                char c = arr[start];
                map.put(c,map.get(c)-1);
                if (map.get(c) == 0)
                    map.remove(c);
                start++;
            }
            maxLen = Math.max(maxLen,end - start + 1);
        }
        if (maxLen == Integer.MIN_VALUE)
            return -1;
        return maxLen;
    }
}
