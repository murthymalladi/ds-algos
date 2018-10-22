package backtracking;

/**
 * Created by dmalladi on 9/23/2018.
 */
public class Sudoku {
    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];
        for (int i = 0 ; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                sudoku[i][j] = 0;
            }
        }

        if (sudokuSolver(sudoku) ) {
            printSudoku(sudoku);
        }
        else {
            System.out.println("no solution exists");
        }

    }
    public static boolean isSafe(int[][] sudoku,int i,int j,int num) {

        if (sudoku[i][j] != 0)
            return false;
        int rowStart = 0, rowEnd = 0,colStart = 0,colEnd = 0;
        if (i%3 == 0) {
            rowStart = i;
            rowEnd = i+ 2;
        }
        if (i%3 == 1) {
            rowStart = i - 1;
            rowEnd = i + 1;
        }
        if (i%3 == 2) {
            rowStart = i -2;
            rowEnd = i;
        }
        //for column
        if (j%3 == 0) {
            colStart = j;
            colEnd = j+ 2;
        }
        if (j%3 == 1) {
            colStart = j - 1;
            colEnd = j + 1;
        }
        if (j%3 == 2) {
            colStart = j -2;
            colEnd = j;
        }

        for (int x = rowStart; x <= rowEnd; x++) {
            for (int y = colStart; y <= colEnd; y++) {
                if (sudoku[x][y] == num)
                    return false;
            }
        }
        for (int col = 0; col < sudoku[0].length; col++) {
            if (sudoku[i][col] == num)
                return false;
        }
        for (int row = 0; row < sudoku.length; row++) {
            if (sudoku[row][j] == num)
                return false;
        }
        return true;

    }


    public static boolean findNextCell(int[][] sudoku,int[] rowCols) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    rowCols[0] = i;
                    rowCols[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean sudokuSolver(int[][] sudoku) {

        int[] rowCols = new int[2];
        if (!findNextCell(sudoku,rowCols)) {
            return true;
        }

        for (int k = 1; k <= 9; k++) {
            if (isSafe(sudoku,rowCols[0],rowCols[1],k)) {
                sudoku[rowCols[0]][rowCols[1]] = k;

                if (sudokuSolver(sudoku)) {
                    //printSudoku(sudoku);
                    return true;
                }
                //backtrack
                sudoku[rowCols[0]][rowCols[1]] = 0;

            }
        }
        return false;
    }
    public static void printSudoku(int[][] sudoku) {
        for (int i = 0 ; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
