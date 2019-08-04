package validations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by dmalladi on 3/25/2019.
 */
public class RemoveInvalidParentheses {
    static int min= Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String[] args) {
        //System.out.println(isValid("()(())()"));
        String exp = "()())()";
        List<String> result  = new ArrayList<>();
        int count = 0;
        valid(exp,0,count,result);
        System.out.println(count);
        System.out.println(result);

    }

    public static void valid(String exp,int start,int count,List<String> result) {
        if (start > exp.length())
            return;
        if (isValid(exp)) {
            if (count < min) {
                min = count;
                result.clear();
                result.add(exp);
            }
            else if (count == min) {
                result.add(exp);
            }
        }


        String first = exp.substring(0,start);
        String second =  (start+1 < exp.length()) ? exp.substring(start+1):"";
        valid(exp,start+1,count,result);

        valid(first+second,start+1,count+1,result);



    }

    public static boolean isValid(String exp) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
