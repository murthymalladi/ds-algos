package dfs;

/**
 * Created by dmalladi on 1/24/2020.
 */
public class NumberOfPatterns {
    static int[][] grid = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };
    public int numberOfPatterns(int m, int n) {
        boolean[][] inResult = new boolean[3][3];
        int[] count = new int[1];
        int prev = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                dfs(inResult,i,j,m,n,0,count,-1,-1);
            }
        }
        return 0;
    }

    public static void dfs(boolean[][] inResult,int i,int j,int m,int n,int len,int[] count,int prevx,int prevy) {
        if (i < 0 || i >= 3 || j < 0 || j >= 3)
            return;
        if (len >= m || len <= n)
            count[0]++;


    }

    public static void main(String[] args) {

    }
}
