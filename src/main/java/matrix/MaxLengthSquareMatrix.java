package matrix;

/**
 * Created by dmalladi on 2/24/2020.
 */
public class MaxLengthSquareMatrix {


    public static int maxLengthSquare(int[][] matrix,int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row][col];

        sum[0][0] = matrix[0][0];

        //process first row
        for (int j = 1; j < col; j++)
            sum[0][j] = sum[0][j-1] + matrix[0][j];

        //process first column

        for (int i = 1; i < row; i++)
            sum[i][0] = sum[i-1][0] + matrix[i][0];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sum[i][j] = matrix[i][j] + sum[i-1][j]+sum[i][j-1] - sum[i-1][j-1];
            }
        }

        int max = 0;
        int curr_max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i >= curr_max && j >= curr_max) {
                    int val = sum[i][j] - sum[i-curr_max][j]
                            - sum[i][j-curr_max] + sum[i-curr_max][j-curr_max];
                    if (val <= k) {
                        max = curr_max;
                        System.out.println("("+i+","+j+")");
                        curr_max++;
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int matrix[][] = { {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };

        int k = 6;

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };
        k = 8;
        int max = maxLengthSquare(matrix2,k);
        System.out.println(max);
    }
}
