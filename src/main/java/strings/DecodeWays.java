package strings;

import java.util.Arrays;

/**
 * Created by dmalladi on 11/12/2018.
 */
public class DecodeWays {

    public static void main(String[] args) {
        String str = "1168963884134125126536966946586868418993819971673459188478711546479621135253876271366851168524933185";
        //    String str = "1234";
//        int ways = numDecodings(str);
//        System.out.println(ways);
        int[] mem = new int[str.length()+1];
        Arrays.fill(mem,-1);
        int num = helper(str,str.length(),mem);
        System.out.println(num);

        int num2 = helperDP(str);
        System.out.println(num2);
    }



    public static int helper(String s,int k,int[] mem) {

        if (k == 0)
            return 1;
        int index = s.length()-k;
        if (s.charAt(index) == '0')
            return 0;
        if (mem[k] != -1)
            return mem[k];
        int count = helper(s,k-1,mem);
        if (k >=2 && Integer.valueOf(s.substring(index,index+2)) <=26) {
            count = count + helper(s,k-2,mem);
        }
        mem[k] = count;
        return count;
    }

    public static int helperDP(String s) {
        if (s.length() == 0)
            return 1;
        if(s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0:1;

        for (int i = 2; i <= s.length();i++) {
            char c2 = s.charAt(i-1);
            char c1 = s.charAt(i-2);
            if (c1 > '0') {
                dp[i] = dp[i-1];
            }
            if  (c1 == '1' || (c1 == '2' && c2 < '7') ) {
                dp[i] = dp[i] + dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public static int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() > 1 && s.charAt(0) == '0')
            return 0;

        if (s.length() == 1 && s.charAt(0) > '0' && s.charAt(0) <= '9')
            return 1;
        else if (s.length() == 1 && s.charAt(0) == '0')
            return 0;
        if (s.length() == 2 && Integer.valueOf(s)> 0 && Integer.valueOf(s) <= 26) {
            return 1 + numDecodings(s.substring(1));
        }
        if (s.length() == 2 && Integer.valueOf(s)> 26) {
            return numDecodings(s.substring(1));
        }


        int value1 = 0;
        value1 = numDecodings(s.substring(1));

        int value2 = 0;

        if (Integer.valueOf(s.substring(0,2)) > 0 && Integer.valueOf(s.substring(0,2)) <= 26) {
            value2 = numDecodings(s.substring(2));
        }
        return value1 + value2;
    }
}
