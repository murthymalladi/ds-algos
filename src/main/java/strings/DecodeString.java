package strings;

import java.util.Stack;

/**
 * Created by dmalladi on 1/15/2020.
 */
public class DecodeString {

    public static void main(String[] args) {
        String str = "100[a]";

        String decrypt = decodeString(str);
        System.out.println(decrypt);
    }

    public static String decodeString(String s) {

        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();

        String res = "";
        int start = 0;
        while(start < s.length()) {
            if (Character.isDigit(s.charAt(start))) {
                StringBuilder num = new StringBuilder();
                num.append(s.charAt(start));
                while(start+1 < s.length() && Character.isDigit(s.charAt(start+1))) {
                    num.append(s.charAt(start+1));
                    start++;
                }
                stackNum.push(Integer.parseInt(num.toString()));
            }
            else if (s.charAt(start) == '[') {
                stack1.push(res);
                res = "";
            }
            else if (s.charAt(start) == ']') {
                int n = stackNum.pop();
                String temp = stack1.pop();
                for (int i = 0; i < n; i++)
                    temp += res;
                res = temp;
            }
            else {
                res += s.charAt(start);
            }
            start++;
        }
        return res;
    }
}
