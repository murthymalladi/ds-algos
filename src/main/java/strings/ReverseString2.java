package strings;

/**
 * Created by dmalladi on 11/19/2018.
 */
public class ReverseString2 {

    public static void main(String[] args) {
        String str = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k = 39;
        String res = reverseStr(str,k);
        System.out.println(res);
    }

    public static String reverseStr(String s, int k) {
        if (s.length() == 0) return s;

        int i = 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        if (s.length() < k) {
            reverse(chars,0,s.length());
            return String.valueOf(chars);
        }
        while(i+k <= len) {
            reverse(chars,i,i+k);
            i = i + 2*k;
        }
        return String.valueOf(chars);
    }

    public static void reverse(char[] chars,int i,int j) {
        char temp;
        while(i < j) {
            temp = chars[i];
            chars[i] = chars[j-1];
            chars[j-1] = temp;
            i++;j--;
        }
    }
}
