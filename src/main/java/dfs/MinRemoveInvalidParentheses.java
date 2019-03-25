package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dmalladi on 12/30/2018.
 */
public class MinRemoveInvalidParentheses {

    public static void main(String[] args) {
        String input = "()())()";
        List<String> output = minRemovePar(input);
        for (String s : output) {
            System.out.println(s);
        }
    }

    public static List<String> minRemovePar(String s) {
        Set<String> res = new HashSet<>();
        if (s == null)
            return new ArrayList<>(res);
        int leftP = 0;
        int rightP = 0;
        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftP++;
            }
            else if (s.charAt(i) == ')') {
                if (leftP > 0) {
                    leftP--;
                }
                else {
                    rightP++;
                }
            }
        }

        dfs(s,0,new StringBuilder(),res,leftP,rightP,0);
        return new ArrayList<>(res);
    }

    public static void dfs(String s,int index,StringBuilder sb,Set<String> res,int leftP,int rightP,int open) {
        if (leftP < 0 || rightP < 0 || open < 0)
            return;
        if (index == s.length()) {
            if (leftP == 0 && rightP == 0 && open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        int len = sb.length();
        if (c == '(') {
            dfs(s,index + 1,sb,res,leftP-1,rightP,open); // not use (
            dfs(s,index+1,sb.append(c),res,leftP,rightP,open+1); //use (
        }
        else if (c == ')') {
            dfs(s,index+1,sb,res,leftP,rightP-1,open); //not use )
            dfs(s,index+1,sb.append(c),res,leftP,rightP,open-1); //use )
        }
        else {
            dfs(s,index+1,sb.append(c),res,leftP,rightP,open);
        }

        sb.setLength(len);
    }
}
