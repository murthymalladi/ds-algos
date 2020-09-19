package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 1/25/2020.
 */
public class EvaluateExpressions {

    public static List<Integer> diffWaysToEvaluateExpression(String input) {

        List<Integer> res = helper(input);
        return res;
    }

    public static List<Integer> helper(String exp) {
        List<Integer> res = new ArrayList<>();
        if (exp.length() == 0)
            return res;
        if (exp.length() == 1) {
            res.add(Integer.parseInt(exp));
            return res;
        }
        for (int i = 0; i < exp.length(); i++) {
            if (isOperator(exp.charAt(i))) {
                List<Integer> left = helper(exp.substring(0,i));
                List<Integer> right = helper(exp.substring(i+1));
                evaluateExp(left,right,res,exp.charAt(i));
            }
        }
        return res;
    }

    public static void evaluateExp(List<Integer> left,List<Integer> right,List<Integer> res,char operator) {

        for (Integer i : left) {
            for (Integer j : right) {
                int val = calc(i,j,operator);
                res.add(val);
            }
        }
    }

    public static int calc(int a,int b,char operator) {
        if (operator == '*')
            return a*b;
        else if (operator == '+')
            return a+b;
        else if (operator == '-')
            return a-b;
        else
            return a/b;
    }

    public static boolean isOperator(char ch) {
        return ch == '*' || ch == '-' || ch == '+' || ch == '/';
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpressions.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpressions.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
