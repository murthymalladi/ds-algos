package strings;

import java.util.HashMap;

/**
 * Created by dmalladi on 2/2/2020.
 */
public class Isomorphic {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);

        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map1.get(s.charAt(i)) != map2.get(t.charAt(i)))
                return false;
            map1.put(s.charAt(i),map1.get(s.charAt(i))-1);
            map2.put(t.charAt(i),map2.get(t.charAt(i))-1);
            if (map1.get(s.charAt(i)) == 0 && map2.get(t.charAt(i)) == 0)
                count++;
        }
        if (count == map1.size())
            return true;
        return false;

    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        if (isIsomorphic(s,t)) {
            System.out.println("isomorphic");
        }
        else {
            System.out.println("not isomorphic");
        }
    }
}
