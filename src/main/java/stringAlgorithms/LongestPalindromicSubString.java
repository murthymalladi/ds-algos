package stringAlgorithms;

import java.util.Arrays;

/**
 * Created by dmalladi on 10/17/2018.
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String s = "aaabaaa";
      //  String len = longestPalindromesubString2(s);
        int len = expandAround(s);
        System.out.println(len);
    }

    public static String longestPalindromeSubString(String s) {
        int len = s.length();
        int[][] table = new int[len][len];
        for (int i = 0; i < len; i++)
            Arrays.fill(table[i],0);

        int max = 1;
        int start = 0;
        // substrings with length 1 are palindromes
        // with length 2 and str[i] == str[i+2] are palindromes of length 2
        for (int i = 0;i < len;i++) {
            table[i][i] = 1;
            start = i;
        }

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = 1;
                start = i;
                max = 2;
            }
        }

        // with length >= 3
        int i;
       for (int k = 3; k <= len ; k++) {
            for (int j = 0; j < len - k + 1; j++) {
               i = j+k-1;
               if (table[j+1][i-1] == 1 && s.charAt(j) == s.charAt(i)) {
                   table[j][i] = 1;
                   if (k > max) {
                       max = k;
                       start = j;
                   }
               }
           }
       }

        return s.substring(start,start+max);
    }
    //space optimized
    public static String longestPalindromesubString2(String s) {
        int len = s.length();
        if (len == 0) return null;
        if (len == 1) return s;

        int max = 1;
        int low = 0;
        int high = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            //for even
            low = i-1;
            high = i;
            while(low>=0 && high < len) {
                if (s.charAt(low) == s.charAt(high)) {

                    low--;
                    high++;
                    count = count + 2;

                }
                else {
                    break;
                }
            }
            if (count > max) {
                start = low+1;
                end = high-1;
                max = count;
            }

            //for odd
            low = i-1;
            high = i+1;
            count = 1;
            while(low>=0 && high < len) {
                if (s.charAt(low) == s.charAt(high)) {
                    low--;
                    high++;
                    count = count + 2;
                }
                else {
                    break;
                }
            }
            if (count > max) {
                max = count;
                start = low+1;
                end = high-1;
            }

        }
         return s.substring(start,end+1);
    }

    public static int expandAround(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int len = Integer.MIN_VALUE;
        for (int center = 0; center < 2*n - 1; center++) {
            int left = center/2;
            int right = left + center%2;

            while(left >=0 && right < n && s.charAt(left) == s.charAt(right)) {
                len = Math.max(len,right-left+1);
                left--;
                right++;

            }


        }
        if (len == Integer.MIN_VALUE)
            return 0;
        return len;
    }
}
