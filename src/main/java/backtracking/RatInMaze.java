package backtracking;

import java.util.Arrays;

/**
 * Created by dmalladi on 9/8/2018.
 */
public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 1, 0},
                        {1, 1, 1, 1}
                       };
        solveMaze(maze);

    }

    public static boolean isSafe(int[][] maze,int i,int j) {
        int rows = maze.length;
        int cols = maze[0].length;
        if (i>= 0 && i < rows && j >=0 && j < cols && maze[i][j] == 1)
            return true;
        else return false;
    }

    public static void solveMaze(int[][] maze) {
        int rows = maze.length;
        int col = maze[0].length;

        int[][] solution = new int[rows][col];
        for (int i = 0; i < rows;i++) {
            for (int j = 0; j < col; j++) {
                solution[i][j] = 0;
            }
        }
        int[] xMove = {0,1};
        int[] yMove = {1,0};
        if (solveMazeUtil(maze,solution,xMove,yMove,0,0) ) {
            printSolution(solution);
        }
        else {
            System.out.println("No solution");
        }

    }

    public static void printSolution(int[][] solution) {
        int rows = solution.length;
        int cols = solution[0].length;

        for (int i = 0; i < rows;i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveMazeUtil(int[][] maze,int[][] solution,int[] xMove,int[] yMove,int i,int j) {

        if (isSafe(maze,i,j)) {
            solution[i][j] = 1;
            if (i == maze.length - 1 && j == maze[0].length - 1) {

                return true;
            }
            for (int k = 0; k < 2; k++) {
                int newX = i + xMove[k];
                int newY = j + yMove[k];
                if (solveMazeUtil(maze,solution,xMove,yMove,newX,newY)) {
                    return true;
                }
            }
            solution[i][j] = 0;
        }
        return false;
    }



}
