package expressions;

import java.util.Stack;

/**
 * @author dmalladi
 */
public class PostFixEvaluation {

    public static void main(String[] args) {
            String postFix = "52+37+8*-";
            evaluateFromPostFix(postFix);
            String[] pos = {"5","2","+","3","7","+","8","*","-"};
            int value = evaluateFromPostFix(pos);
            System.out.println(value);
    }

    /**
     * Take postfix expression as a single string. Assume that use only number with single digit.
     * @param postFix
     */
    public static void evaluateFromPostFix(String postFix) {
        Stack<Integer> stack = new Stack<Integer>();
        Character ch;
        int firstInt;
        int secondInt;
        int value;
        for (int i = 0; i < postFix.length(); i++) {
            ch = postFix.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(Integer.parseInt(ch.toString()));
            }
            if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                if (ch == '+') {
                    secondInt = stack.pop();
                    firstInt = stack.pop();
                    value = firstInt+secondInt;
                    stack.push(value);
                }
                else if (ch == '-') {
                    secondInt = stack.pop();
                    firstInt = stack.pop();
                    value = firstInt - secondInt;
                    stack.push(value);
                }
                else if (ch == '/') {
                    secondInt = stack.pop();
                    firstInt = stack.pop();
                    value = firstInt / secondInt;
                    stack.push(value);
                }
                else if (ch == '*') {
                    secondInt = stack.pop();
                    firstInt = stack.pop();
                    value = firstInt * secondInt;
                    stack.push(value);
                }

            }

        }
        value = stack.pop();

        System.out.println("value: " + value);
    }

    public static int evaluateFromPostFix(String[] postFix) {
        Stack<String> stack = new Stack<String>();
        String operator = "+-/*";
        for (String token: postFix) {
            if (!operator.contains(token)) {
                stack.push(token);
            }
            else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                int index = operator.indexOf(token);
                if (index == 0) {
                    stack.push(String.valueOf(a + b));
                }
                else if (index == 1) {
                    stack.push(String.valueOf(b - a));
                }
                else if (index == 2) {
                    stack.push(String.valueOf(b / a));
                }
                else if (index == 3) {
                    stack.push(String.valueOf(b * a));
                }
            }
        }

        return Integer.valueOf(stack.pop());
    }
}
