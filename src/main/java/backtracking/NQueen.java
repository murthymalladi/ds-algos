package backtracking;

/**
 * Created by dmalladi on 9/8/2018.
 */
public class NQueen {

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
    public static boolean solveNQueen(int[][] board) {

        for (int i = 0; i < board[0].length; i++) {
            //for first queen
            board[0][i] = 1;
            for (int k = 0; k < board[0].length; k++) {
                if (isSafe(board,1,k)) {
                    //second queen
                    board[1][k] = 1;
                    for (int j = 0; j < board[0].length; j++) {
                        if (isSafe(board,2,j)) {
                            //3rd queen
                            board[2][j] = 1;
                            for (int w = 0; w < board[0].length; w++) {
                                if (isSafe(board,3,w)) {
                                    //4th queen
                                    board[3][w] = 1;
                                    return true;
                                }
                            }
                            board[2][j] = 0;
                        }
                    }
                    board[1][k] = 0;
                }
            }
            board[0][i] = 0;
        }
        return false;
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
