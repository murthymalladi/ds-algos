package dfs;

import java.util.Arrays;

/**
 * Created by dmalladi on 1/15/2020.
 */
public class LongestPathInGrid {

    static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans,dfs(matrix,i,j,cache));
            }
        }
        return ans;
    }

    public static int dfs(int[][] matrix,int i,int j,int[][] cache) {
        if (cache[i][j] > 0)
            return cache[i][j];
        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y] ) {
                cache[i][j] = Math.max(cache[i][j],dfs(matrix,x,y,cache));
            }
        }
        return  ++cache[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {7,6,1,1},
                {2,7,6,0},
                {1,3,5,1},
                {6,6,3,2}
        };

        int[][] matrix2 = {
                {7,8,9},
                {9,7,6},
                {7,2,3}
        };

        int len = longestIncreasingPath(matrix2);
        System.out.println(len);
    }
}
