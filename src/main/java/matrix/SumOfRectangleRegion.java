package matrix;

/**
 * Created by dmalladi on 10/18/2018.
 */
public class SumOfRectangleRegion {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        precompute(matrix);
        print(matrix);
        int val = findRectangleSum(matrix,1,1,2,2);
        System.out.println(val);
    }

    public static void print(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static int findRectangleSum(int[][] matrix,int x,int y,int i,int j) {
        int sum = matrix[i][j];
        sum = sum - matrix[i][y-1] - matrix[x-1][j] + matrix[x-1][y-1];
        return sum;
    }

    public static void precompute(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // add elements column wise
        for (int j = 1; j < col; j++) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j-1];
            }
        }

        //add elements row wise
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i-1][j];
            }
        }
    }
}
