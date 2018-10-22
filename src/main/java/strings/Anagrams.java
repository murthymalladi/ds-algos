package strings;

import java.util.Arrays;

/**
 * Created by dmalladi on 10/17/2018.
 */
public class Anagrams {
    public static void main(String[] args) {
        String str1 = "bass";
        String str2 = "asbs";
        if (areAnagrams2(str1.toCharArray(),str2.toCharArray())) {
            System.out.println("given strings are anagrams");
        }
        else {
            System.out.println("given strings are not anagrams");
        }
    }

    public static boolean areAnagrams(char[] str1,char[] str2) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        Arrays.fill(map1,0);
        Arrays.fill(map2,0);

        if (str1.length != str2.length)
            return false;
        for (int i = 0; i < str1.length; i++) {
            map1[str1[i]]++;
            map2[str2[i]]++;
        }

        for (int i = 0; i < 256; i++) {
            if (map1[i] != map2[i])
                return false;
        }
        return true;
    }

    public static boolean areAnagrams2(char[] str1,char[] str2) {
        if (str1.length != str2.length)
            return false;
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i])
                return false;
        }
        return true;
    }
}
