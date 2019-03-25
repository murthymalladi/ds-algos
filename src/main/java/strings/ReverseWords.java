package strings;

/**
 * Created by dmalladi on 11/11/2018.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String str = "";
        String rev = reverseWords2(str);
        System.out.println(rev);
    }

    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        reverse(str,0,str.length-1);
        System.out.println(str);
        int start = 0;
        int i=0;
        while(i < str.length) {
            while(i < str.length && str[i] != ' ') i++;
            reverse(str,start,i-1);
            start = i+1;
            i++;
        }
        if (i == str.length) {
            reverse(str,start,i-1);
        }
        return String.valueOf(str);
    }

    public static void reverse(char[] s,int start,int end) {
        char temp;
        while(start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;end--;
        }

    }

    public static String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            }
            else {
                if (i == 0 || s.charAt(i-1) == ' ') {
                    if (sb.length() != 0) {
                        sb.append(" ");
                    }
                    sb.append(s.substring(i,j));
                }
            }
        }
        return sb.toString();
    }
}
