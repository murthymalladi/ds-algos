package strings;

import java.util.Arrays;

/**
 * Created by dmalladi on 10/16/2018.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        String str = "aabbcd";
        removeDuplicates2(str.toCharArray());
    }

    /**
     *  without extra space O(n^2)
     * @param str
     */
    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int tail = 1;
        for (int i = 1;i < len; i++) {
            int j;
            for (j = 0;j < tail; j++) {
                if (str[i] == str[j])
                    break;
            }
            if (j == tail) {
                str[tail] = str[i];
                tail++;
            }
        }
        str[tail] = 0;

        for (int i = 0; i < tail; i++) {
            System.out.print(str[i]);
        }
    }

    public static void removeDuplicates2(char[] str) {
        boolean[] map = new boolean[256];
        int tail = 1;
        Arrays.fill(map,false);
        map[str[0]] = true;

        for (int i = 1; i < str.length; i++) {
            //if unseen char
            if (!map[str[i]]) {
                str[tail] = str[i];
                map[str[i]] = true;
                tail++;
            }
       }
       str[tail] = 0;

        //print the string
        for (int i = 0; i < tail; i++) {
            System.out.print(str[i]);
        }
        System.out.println();

    }
}
