package validations;

import java.util.Stack;

/**
 * Created by dmalladi on 10/22/2018.
 */
public class LongestValidParenthesis {

    public static void main(String[] args) {
        String str = "()()()(()()()())";
        int length = longestPArenthesisV2(str);
        System.out.println(length);
    }

    public static int lengthOfLongestValidParenthesis(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) return 0;

        Stack<int[]> stack = new Stack<int[]>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {


            if (str.charAt(i) == '(') {
                int[] arr = {i,0};
                stack.push(arr);
            }
            else {
                if (stack.isEmpty() || stack.peek()[1] == 1)
                    stack.push(new int[]{i,1});
                else {
                    stack.pop();
                    int currLength = 0;
                    if (stack.isEmpty()) {
                        currLength = i+1;
                    }
                    else {
                        currLength = i - stack.peek()[0];
                    }
                    result = Math.max(result,currLength);
                }
            }

        }
        return result;
    }

    public static int longestPArenthesisV2(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();

                if (!stack.isEmpty()) {
                    result = Math.max(result,i - stack.peek());
                }
                else {
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
