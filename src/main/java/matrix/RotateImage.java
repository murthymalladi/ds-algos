package matrix;

/**
 * Created by dmalladi on 11/8/2018.
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
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

    public static void transpose(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i != j && i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

    }
    public static void rotate(int[][] image) {
        transpose(image);
        columnChange(image);
    }

    public static void columnChange(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        for (int j = 0; j < colLength/2; j++) {
            for (int i = 0; i < rowLength; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][colLength-1-j];
                matrix[i][colLength-1-j] = temp;
            }
        }
    }
}
