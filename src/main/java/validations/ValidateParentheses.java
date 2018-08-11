package validations;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author dmalladi
 */
public class ValidateParentheses {

    public static void main(String[] args) {

        String parentheses = "((()))";
        System.out.println("enter parentheses");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String str = in.nextLine();
        if (validate(str)) {
            System.out.println("valid parentheses");
        }
        else {
            System.out.println("not a valid parentheses");
        }

    }

    public static boolean validate(String parentheses) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < parentheses.length(); i++) {

            if (parentheses.charAt(i) == '(') {
                stack.push(parentheses.charAt(i));
            }
            else if (parentheses.charAt(i) == ')') {
                Character ch = stack.pop();
                if (ch != '(') {
                    return false;
                }
            }
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
