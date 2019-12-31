package sequence;

import java.util.HashSet;

/**
 * Created by dmalladi on 9/1/2019.
 */
public class PrintAllsubSequences {

    public static void main(String[] args) {
        String str = "aabc";
        HashSet<String> set = new HashSet<>();
        getAllSubSequences(str,set);
        System.out.println(set);

    }

    public static void getAllSubSequences(String str,HashSet<String> set) {
        for (int i = 0; i < str.length(); i++) {

            for (int j = str.length(); j > i; j--) {
                String subString = str.substring(i,j);
                if (!set.contains(subString)) {
                    set.add(subString);
                }

                for (int k = 1; k < subString.length(); k++) {
                    StringBuilder sb = new StringBuilder(subString);
                    sb.deleteCharAt(k);
                    if (!set.contains(sb.toString())) {
                        getAllSubSequences(sb.toString(),set);
                    }
                }

            }
        }
    }
}
