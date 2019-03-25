package sequence;

/**
 * Created by dmalladi on 11/18/2018.
 */
public class LongestCommonSequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int len = lcs(s1.toCharArray(),s1.length(),s2.toCharArray(),s2.length());
        int len2 = dp(s1.toCharArray(),s2.toCharArray());
        System.out.println(len2);
    }

    public static int lcs(char[] X,int m,char[] Y,int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X,m-1,Y,n-1);

        return Math.max(lcs(X,m-1,Y,n),lcs(X,m,Y,n-1));
    }

    public static int dp(char[] X,char[] Y) {
        int m = X.length;
        int n = Y.length;
        int[][] lcs = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (X[i-1] == Y[j-1]) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                }
                else {
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        print(lcs);
        return lcs[m][n];

    }

    public static void print(int[][] lcs) {
        for (int i = 0; i < lcs.length; i++) {
            for (int j = 0; j < lcs[0].length; j++) {
                System.out.print(lcs[i][j] +" ");
            }
            System.out.println();
        }
    }
}
