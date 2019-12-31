package patterns.slidingwindow;

import java.util.HashMap;

/**
 * Created by dmalladi on 9/13/2019.
 */
public class StringContainsPermutation {

    public static void main(String[] args) {
        String str = "odicf";
        String pattern = "dc";

        boolean flag = findPermutation(str,pattern);
        if (flag) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public static boolean findPermutation(String str, String pattern) {

        if (str.length() == 0 )
            return false;
        if (pattern.length() == 0)
            return true;

        int start = 0;
        int match = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int end = 0; end < str.length(); end++) {
            char rightChar = str.charAt(end);

            if (map.containsKey(rightChar)) {
                map.put(rightChar,map.get(rightChar)-1);
                if (map.get(rightChar) == 0)
                    match++;
            }
            if (match == map.size())
                return true;

            if (end >= pattern.length()-1) {
                char leftChar = str.charAt(start);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0)
                          match--;
                    map.put(leftChar,map.get(leftChar)+1);
                }
                start++;
            }
        }
        return false;
    }
}
