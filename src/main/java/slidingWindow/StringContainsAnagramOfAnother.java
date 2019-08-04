package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmalladi on 4/4/2019.
 */
public class StringContainsAnagramOfAnother {

    public static void main(String[] args) {
        String source = "machine learning engineer";
        //String target = "ningreal";
        String target = "abcd";
        if (containsAnagram(source,target)) {
            System.out.println("yes");
        }
        else {
            System.out.println("No");
        }
    }

    public static boolean containsAnagram(String source,String target) {
        int len = source.length();
        int window = target.length();
        int start = 0,end = window;
        while(end < len) {
           if (isAnagram(source.substring(start,end),target) ) {
               return true;
           }
           start++;
           end++;
        }
        return false;
    }

    public static boolean isAnagram(String s,String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count = map.size();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) <= 0)
                    return false;
                map.put(c,map.get(c)-1);
                if (map.get(c) == 0)
                    count--;
            }
        }
        if (count == 0)
            return true;
        return false;
    }

}
