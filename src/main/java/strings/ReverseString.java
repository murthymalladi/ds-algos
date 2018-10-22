package strings;

/**
 * Created by dmalladi on 10/16/2018.
 */
public class ReverseString {

    public static void main(String[] args) {
        String str = "advc";
        char[] charArray = str.toCharArray();
        reverse(charArray);
        System.out.println(charArray);
    }

    public static void reverse(char[] str) {
        int start = 0;
        int end = str.length - 1;
        char ch;
        while(start <= end) {
            ch = str[start];
            str[start] = str[end];
            str[end] = ch;
            start++;
            end--;
        }
    }
}
