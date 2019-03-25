package dp;

/**
 * Created by dmalladi on 11/9/2018.
 */
public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 23;
        if (search(matrix,target)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    public static boolean search(int[][] matrix,int target) {
        int R = matrix.length;
        int C = matrix[0].length;
        int i = 0;
        int j = C-1;

        while(i < R && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
}
