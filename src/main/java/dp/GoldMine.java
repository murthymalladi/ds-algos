package dp;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer
 * which is the amount of gold in tons. Initially the miner is at first column but can be at any row.
 * He can move only (right->,right up /,right down\) that is from a given cell, the miner can move
 * to the cell diagonally up towards the right or right or diagonally down towards the right.
 * Find out maximum amount of gold he can collect.
 */
public class GoldMine {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 3},
                          {2, 1, 4},
                          {0, 6, 4}
                         };

        int[][] matrix2 = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};

        int[][] matrix3 = {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};

        int max = maxGold(matrix3);
        System.out.println(max);
    }

    public static int maxGold(int[][] mine) {
        int[][] sol = new int[mine.length][mine[0].length];
        for (int i = 0; i < mine.length; i++)
            sol[i][0] = mine[i][0];

        for (int col = 1; col < mine[0].length; col++) {
            for (int row = 0; row < mine.length; row++) {
                int val1 =  row == 0? 0: sol[row-1][col-1];
                int val2 = sol[row][col-1];
                int val3 = row == mine.length - 1 ? 0 : sol[row+1][col-1];
                sol[row][col] = maxVal(val1+mine[row][col],val2+mine[row][col],val3+mine[row][col]);
            }
        }

        int max = sol[0][mine[0].length-1];
        for (int i = 0; i < mine.length; i++) {
            max = Math.max(max, sol[i][mine[0].length-1]);
        }

        return max;
    }

    public static int maxVal(int val1,int val2,int val3) {
        int max = Math.max(val1,val2);
        max = Math.max(max,val3);
        return max;
    }
}
