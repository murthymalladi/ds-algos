package validations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;


/**
 * Created by dmalladi on 10/21/2018.
 */
public class ValidAllKindsOfParenthesis {

    public static void main(String[] args) {


        String str = "{{()}}}";
        if (validate(str)) {
            System.out.println("valid parentheses");
        }
        else {
            System.out.println("not a valid parentheses");
        }

    }

    public static boolean validate(String str) {
        if (str == null || str.length() == 0) return false;
        Stack<Character> stack = new Stack<Character>();
        char peek;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')') {
                peek = stack.pop();
                if (peek != '(')
                    return false;
            }
            else if (ch == '}') {
                peek = stack.pop();
                if (peek != '{')
                    return false;
            }
            else if (ch == ']') {
                peek = stack.pop();
                if (peek != '[')
                    return false;
            }
        }
        return true;
    }
}
