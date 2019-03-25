package strings;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/7/2018.
 */
public class FirstNonReapeatingChar {

    public static void main(String[] args) {
        String str = "leetcode";
        int index = firstUniqChar(str);
        System.out.println(index);
    }

    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i],map.getOrDefault(charArray[i],0)+1);
        }

        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
