package backtracking;

/**
 * Created by dmalladi on 9/8/2018.
 */
public class NQueenGeneric {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        fillBoard(board,0);
        if ( solveNQueen(board)) {
            printBoard(board);
        }
        else {
            System.out.println("solution does not exist");
        }
    }

    public static boolean solveNQueen(int[][] board) {

        int numQueen = 0;
        return recursive(board,numQueen);
    }

    public static boolean recursive(int[][] board,int q) {

        for (int column = 0; column < board[0].length; column++) {
            if (isSafe(board,q,column)) {
               board[q][column] = 1;
               if (q == board.length - 1) {
                   return true;
               }
                if (recursive(board,q+1)) {
                    return true;
                }
                board[q][column] = 0;
            }
        }
        return false;
    }


    public static boolean isSafe(int[][] board,int i,int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (board[i][j] == 1)
            return false;
        //check row
        for (int k = 0; k < cols; k++) {
            if (board[i][k] == 1)
                return false;
        }
        //check column
        for (int k = 0; k < rows; k++) {
            if (board[k][j] == 1)
                return false;
        }
        //check upper left diagonal
        int x = i;
        int y = j;

        while (x > 0 && y > 0) {
            x = x -1;
            y = y -1;
            if (board[x][y] == 1)
                return false;
        }

        //check lower right digonal

        x = i;
        y = j;

        while(x < rows - 1 && y < cols - 1) {
            x = x+1;
            y = y+1;
            if (board[x][y] == 1)
                return false;
        }

        //check upper right diagonal
        x = i;
        y = j;

        while(x > 0 && y < cols - 1) {
            x = x -1;
            y = y + 1;
            if (board[x][y] == 1)
                return false;
        }

        //check lower left diagonal

        x = i;
        y = j;

        while(x < rows - 1 && y > 0) {
            x = x + 1;
            y = y - 1;
            if (board[x][y] == 1)
                return false;
        }
        return true;
    }

    public static void fillBoard(int[][] board,int value) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length;j++) {
                board[i][j] = value;
            }
        }

    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length;j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
