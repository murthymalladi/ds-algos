package matrix;

/**
 * Created by dmalladi on 11/8/2018.
 */
public class FillSpiralMatrix {

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = generateMatrix(n);
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

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rStart = 0;
        int rEnd = n-1;
        int cStart = 0;
        int cEnd = n-1;
        int count = 1;
        while(rStart <= rEnd && cStart<= cEnd) {

            for (int i = cStart; i<= cEnd; i++) {
                matrix[rStart][i] = count;
                count++;
            }
            rStart++;
            if (rStart > rEnd) break;

            for (int j = rStart; j<= rEnd; j++) {
                matrix[j][cEnd] = count;
                count++;
            }
            cEnd--;
            if (cEnd < cStart) break;

            for (int k = cEnd; k >= cStart; k--) {
                matrix[rEnd][k] = count;
                count++;
            }
            rEnd--;
            if (rEnd < rStart) break;

            for (int m = rEnd; m >= rStart; m--) {
                matrix[m][cStart] = count;
                count++;
            }
            cStart++;
            if (cStart > cEnd) break;
        }

        return matrix;
    }
}
