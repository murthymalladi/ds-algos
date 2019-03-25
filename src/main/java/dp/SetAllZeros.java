package dp;

/**
 * Created by dmalladi on 11/9/2018.
 */
public class SetAllZeros {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        int[][] matrix = {
                {0,1,2,0}

        };
        setAllZeros(matrix);
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void setAllZeros(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[] row = new int[R];
        int[] col = new int[C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}
