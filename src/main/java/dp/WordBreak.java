package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmalladi on 8/6/2019.
 */
public class WordBreak {

    static Set<String> dict = new HashSet<>();
    public static void main(String[] args) {
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        for (String str : temp_dictionary) {
            dict.add(str);
        }
        String s = "ilikesamsung";
        //boolean isTrue = wordBreakRecur2(s);
        boolean isTrue = dp2(s);
        if (isTrue) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    //method 1
    public static boolean wordBreakRecur(String s) {
        int len = s.length();
        //base case
        if (len == 0)
            return true;
        for (int i = 1; i < len+1; i++) {
            if (dict.contains(s.substring(0,i)) && wordBreakRecur(s.substring(i)))
                return true;
        }
        return false;
    }

    //method 2

    public static boolean wordBreakRecur2(String s) {
        return wordBreakHelper(s,dict,0);
    }

    public static boolean wordBreakHelper(String s, Set<String> dict,int start) {

        //base case
        if (start == s.length())
            return true;
        for (String a : dict) {
            int len = a.length();
            int end = start + len;
            if (end > s.length())
                continue;
            if (s.substring(start,end).equals(a)) {
                if (wordBreakHelper(s,dict,start+len))
                    return true;
            }
        }
        return false;
    }

    public static boolean dp1(String s) {
        int n = s.length();
        boolean[] w = new boolean[n+1];
        Arrays.fill(w,false);

        for (int i = 1; i <= n; i++) {

            if (w[i] == false && dict.contains(s.substring(0,i)))
                 w[i] = true;

            for (int j = i+1; j<=n; j++) {
                if (w[j] == false && dict.contains(s.substring(i,j)))
                    w[i] = true;

                if (j == n && w[j] == true)
                    return true;
            }
        }
        return false;
    }

    //small modification to above method

    public static boolean dp2(String s) {
        boolean[] dp = new boolean[s.length()+1];

        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {

            if (dp[i]) {
                for (int j = i+1; j <= s.length(); j++) {
                    String sub = s.substring(i,j);
                    if (dict.contains(sub))
                        dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
