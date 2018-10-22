package stringAlgorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by dmalladi on 10/11/2018.
 */
public class LongestSubString {
    public static void main(String[] args) {
        String str = "abba";
        int max = longestSubString(str);
        System.out.println(max);
    }

    public static int longestSubString(String str) {
        int[] arr = new int[str.length()];
        Arrays.fill(arr,1);
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put(str.charAt(0),0);
        for (int i = 1; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int index = map.get(str.charAt(i));
                map.put(str.charAt(i),i);
                if (i - arr[i-1] > index) {
                    arr[i] = arr[i-1] + 1;
                }
                else {
                    arr[i] = i - index ;
                }

            }
            else {
                map.put(str.charAt(i),i);
                arr[i] = arr[i-1]+1;
            }
        }
        return maxVal(arr);
    }

    public static int maxVal(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
