package strings;

/**
 * Created by dmalladi on 11/11/2018.
 */
public class ScrambleStrings {

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        if (isScramble(s1,s2)) {
            System.out.println("scramble strings");
        }
        else {
            System.out.println("not scramble strings");

        }
    }

    public static boolean isScramble(String s1,String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.length() == 0)
            return true;
        if (s1.equals(s2))
            return true;

        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++)
            if (chars[i] != 0)
                return false;

        int len = s1.length();
        for (int i = 1; i < len; i++) {
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i,len);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i,len);
            String s23 = s2.substring(0,len-i);
            String s24 = s2.substring(len-i,len);

            if (isScramble(s11,s21) && isScramble(s12,s22))
                return true;
            if (isScramble(s11,s24) && isScramble(s12,s23))
                return true;
        }

        return false;
    }
}
