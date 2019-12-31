package strings;

import java.util.HashMap;

/**
 * Created by dmalladi on 12/30/2019.
 */
public class ExpressiveWords {

    public static int expressiveWords(String S, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isExpressive(S,words[i]))
                count++;
        }
        return count;
    }

    public static boolean isExpressive(String source,String target) {

        int countT = 0;
        int countS = 0;
        int j = 0;
        int i = 0;

        while(i < source.length() && j < target.length()) {
            countT = 1;
            while(j+1 < target.length() && target.charAt(j) == target.charAt(j+1)) {
                j++;
                countT++;
            }

            countS = 1;
            while(i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) {
                i++;
                countS++;
            }
            if (i < source.length()&& j < target.length() && source.charAt(i) == target.charAt(j)) {
                if (countT == countS || (countS >= 3) && (countT < countS) ) {
                    i++;
                    j++;
                }
                else {
                    return false;
                }
            }
            else {
                break;
            }

        }

        return i == source.length() && j == target.length();
    }

    public static void main(String[] args) {
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};

        int n = expressiveWords(S,words);
        System.out.println(n);
    }
}
