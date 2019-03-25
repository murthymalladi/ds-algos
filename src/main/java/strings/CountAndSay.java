package strings;

/**
 * Created by dmalladi on 11/10/2018.
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n = 7;
        String val = countAndSay(n);
        System.out.println(val);
    }

    public static String countAndSay(int n) {

        String str = "1";

        for (int k = 1; k < n; k++) {
            String temp = "";
            int j = 0;
            while(true) {
                int count = 1;

                while(j<str.length()-1 && str.charAt(j) == str.charAt(j+1)) {
                    count++;j++;
                }
                temp += String.valueOf(count)+String.valueOf(str.charAt(j));
                if (j == str.length()-1)
                    break;
                j++;
            }
            str = temp;
        }

        return str;
    }
}
