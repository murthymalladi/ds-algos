package backtracking;

/**
 * Created by dmalladi on 8/30/2018.
 */
public class KnightTour {

    public static void main(String[] args) {
        int[][] board = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = -1;
            }
        }
        getTour(board);
    }
    public static void printTour(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int i,int j,int[][] visited) {
        if (i>=0 && i<8 && j>=0 && j < 8 && visited[i][j] == -1)
            return true;
        return false;
    }

    public static void getTour(int[][] board) {
        int[] x = {-2,-1,1,2,2,1,-1,-2};
        int[] y = {1,2,2,1,-1,-2,-2,-1};
        int[][] visited = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                visited[i][j] = -1;
            }
        }
        if (solveIT(board,x,y,0,0,0)) {
            printTour(board);
        }
        else {
            System.out.println("\n\nno solution exist");
        }

    }

    public static boolean solveIT(int[][] board,int[] x,int[] y,int i,int j,int count) {
        if (isSafe(i,j,board)) {

            board[i][j] = count;
            if (count == 63) {
                return true;
            }
            for (int k = 0; k < 8; k++) {
                int newX = i + x[k];
                int newY = j + y[k];
                if (solveIT(board,x,y,newX,newY,count+1)) {
                    return true;
                }
           }
            //backtrack
            board[i][j] = -1;
        }
        return false;
    }
}
