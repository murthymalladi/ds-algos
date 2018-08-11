package arrays;

/**
 * Created by dmalladi on 7/27/2018.
 */
public class HourGlassSum {

    public static void main(String[] args) {

        int[][] arr = {
                {-9,-9,-9, 1, 1, 1},
                {0, -9,  0,  4, 3, 2 },
                {-9, -9, -9,  1, 2, 3},
                {0,  0,  8,  6, 6, 0},
                {0,  0,  0, -2, 0, 0},
                {0,  0,  1,  2, 4, 0}
        };

        int sum = hourGlassSum(arr);
        System.out.println("sum : "+ sum);
    }

    public static int hourGlassSum(int[][] arr) {
        int[] x = {-1,1,1,1,-1,-1};
        int[] y = {1,1,0,-1,-1,0};

        int rowLength = arr.length;
        int colLength = arr[0].length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i < rowLength - 1; i ++) {
            for (int j = 1; j < colLength - 1; j++) {
                sum = arr[i][j];
                for (int k = 0; k < 6; k++) {
                     sum += arr[x[k] + i][y[k] + j];
                }
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }
}
