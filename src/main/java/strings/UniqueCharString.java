package strings;

import java.util.HashSet;

/**
 * Created by dmalladi on 10/16/2018.
 */
public class UniqueCharString {

    public static void main(String[] args) {
        String input = "abcdefgh123";
        if (isUniqueChar(input)) {
            System.out.println("unique char string");
        }
        else {
            System.out.println("not a unique char string");
        }
    }

    /**
     * with extra space
     * @param str
     * @return
     */
    public static boolean isUniqueChar(String str) {
        HashSet<Character> set = new HashSet<Character>();
        Character ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    //without extra space
    public static boolean isUniqueChar2(String str) {
        return false;
    }
}
