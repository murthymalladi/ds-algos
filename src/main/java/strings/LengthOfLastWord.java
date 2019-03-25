package strings;

/**
 * Created by dmalladi on 10/24/2018.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String str = "    ";
        int length = lastWordLength(str);
        System.out.println(length);
    }

    public static int lastWordLength(String s) {
//        String[] words = str.split(" ");
//        return words[words.length - 1].trim().length();
        int len = s.length()-1;
        while (s.charAt(len) == ' ')
            len--;
        if (len == -1) return 0;
        int i = len;
        char ch;
        while(i >= 0 ) {
            ch = s.charAt(i);
            if (ch != ' ')
                i--;
            else break;

        }


        return len - i;
    }
}
