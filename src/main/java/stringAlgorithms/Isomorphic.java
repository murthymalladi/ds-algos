package stringAlgorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dmalladi
 */
public class Isomorphic {

    public static void main(String[] args) {
        String str1 = "paper";
        String str2 = "title";

        if (isIsomorphicV2(str1,str2)) {
            System.out.println("isomorphic");
        }
        else {
            System.out.println("not a isomorphic");
        }
    }

    /**
     *  O(n*n) solution
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isIsomorphic(String s1,String s2) {
        if (s1.length() != s2.length())
            return false;
        Map<Character,Character> map = new HashMap<Character,Character>();

        for (int  i= 0; i < s1.length(); i++) {

            if (!map.containsKey(s1.charAt(i))) {
                if (map.containsValue(s2.charAt(i)))
                    return false;
                map.put(s1.charAt(i),s2.charAt(i));
            }
            else {
                Character ch = map.get(s1.charAt(i));
                if (ch != s2.charAt(i))
                    return false;
            }
        }
        return true;
    }

    /**
     *  O(n) solution
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isIsomorphicV2(String s1,String s2) {
        if (s1.length() != s2.length())
            return false;
        Map<Character,Character> map = new HashMap<Character,Character>();
        int[] visited = new int[256];
        Arrays.fill(visited,0);
        for (int  i= 0; i < s1.length(); i++) {

            if (!map.containsKey(s1.charAt(i))) {
                if (visited[s2.charAt(i)] == 1)
                    return false;
                map.put(s1.charAt(i),s2.charAt(i));
                visited[s2.charAt(i)] = 1;
            }
            else {
                Character ch = map.get(s1.charAt(i));
                if (ch != s2.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
