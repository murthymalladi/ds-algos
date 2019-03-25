package dfs;

import java.util.Arrays;

/**
 * Created by dmalladi on 1/26/2019.
 */
public class LongIncreasingPAth {
    static int[][] moves = {{0,1},{0,-1},{-1,0},{1,0} };

    public static void main(String[] args) {
        int[][] matrix = {
                          {7,6,1,1},
                          {2,7,6,0},
                          {1,3,5,1},
                          {6,6,3,2}
                        };

        int len = longestIncreasingPath(matrix);
        System.out.println(len);
    }
    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int curMax = 0;
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                curMax = dfs(matrix,cache,i,j,Integer.MIN_VALUE);
                if (curMax > max)
                    max = curMax;

            }
        }

        return max;
    }

    public static int dfs(int[][] matrix,int[][] cache,int x,int y,int value) {

        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                ||  matrix[x][y] <= value)
            return 0;

        if (cache[x][y] != 0)
            return cache[x][y];

        int max = 0;

        for (int i = 0 ;i < 4; i++) {
            int x_new = x + moves[i][0];
            int y_new = y + moves[i][1];
            int len =  dfs(matrix,cache,x_new,y_new,matrix[x][y]);
            max = Math.max(max,len);
        }
        cache[x][y] = max+1;
        return max+1;
    }


}
