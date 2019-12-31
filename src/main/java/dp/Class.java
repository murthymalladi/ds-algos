package dp;


class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0)
            return true;
        if (t.length() == 0)
            return false;

        return dp(s.toCharArray(),t.toCharArray());
    }

    public boolean dp(char[] s,char[] t) {
        int m = s.length;
        int n = t.length;

        boolean[][] table = new boolean[n+1][m+1];

        //base cases
        for (int i = 0; i <= n; i++)
            table[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t[i-1] == s[j-1])
                    table[i][j] = table[i-1][j-1];
                else {
                    table[i][j] = table[i-1][j];
                }
            }
        }
        return table[n][m];
    }
}

