package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 11/8/2018.
 */
public class SpiralPRint {
    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11,1,2},
                {2, 4, 8,10,1,3},
                {13, 3, 6, 7,1,4},
                {12, 8, 9, 2,1,5},
                {15,14,12,16,1,6}

        };
       // spiralPrint(matrix);
        System.out.println(spiralOrder(matrix));
    }

    public static void spiralPrint(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        int count = 0;
        int totalElements = matrix[0].length*matrix.length;
        while(rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(matrix[rowStart][i] +" ");
                count++;
            }
            if (count == totalElements)
                break;
            rowStart++;

            for (int j = rowStart; j <= rowEnd; j++) {
                System.out.print(matrix[j][colEnd] +" ");
                count++;
            }
            if (count == totalElements)
                break;
            colEnd--;

            for (int k = colEnd; k >=colStart; k--) {
                System.out.print(matrix[rowEnd][k] +" ");
                count++;
            }
            if (count == totalElements)
                break;
            rowEnd--;
            for (int m = rowEnd; m >= rowStart; m--) {
                System.out.print(matrix[m][colStart] +" ");
                count++;
            }
            if (count == totalElements)
                break;
            colStart++;
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;

        while (true) {
            for (int i = left; i <= right; ++i) res.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; ++i) res.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; --i) res.add(matrix[bottom][i]);
            if (--bottom < top) break;
            for (int i = bottom; i >= top; --i) res.add(matrix[i][left]);
            if (++left > right) break;
        }

        return res;
    }
}
