package bfs;

import java.util.Arrays;

/**
 * Created by dmalladi on 3/18/2020.
 */
public class WallsAndGates {
    static int[][] moves = {{-1,0},{1,0},{0,1},{0,-1}};


    public static void wallsAndGates(int[][] rooms) {

        if (rooms.length == 0)
            return;
        int r = rooms.length;
        int c = rooms[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rooms[i][j] == 0) {

                    for(boolean[] arr : visited) {
                        Arrays.fill(arr,false);
                    }
                    dfs(rooms,i,j,visited,0);
                }
            }
        }
    }

    public static void dfs(int[][] rooms,int i,int j,boolean[][] visited,int val) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || visited[i][j] || rooms[i][j] == -1)
            return;

        if (rooms[i][j] > val) {
            System.out.println("yes");
            rooms[i][j] = val;
        }
        visited[i][j] = true;
        if (rooms[i][j] > val) {
            rooms[i][j] = val;
        }

        for (int k = 0; k < 4; k++) {
            int new_r = i + moves[k][0];
            int new_c = j+moves[k][1];
            dfs(rooms,new_r,new_c,visited,val+1);
        }
    }

    public static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] +"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1000,-1,0,1000},
                {1000,1000,1000,-1},
                {1000,-1,1000,-1},
                {0,-1,1000,1000}
            };

        wallsAndGates(matrix);
        print(matrix);
    }
}
