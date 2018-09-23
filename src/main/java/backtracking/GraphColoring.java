package backtracking;

import java.util.Arrays;

/**
 * Created by dmalladi on 9/9/2018.
 */
public class GraphColoring {
    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1},
                         {1, 0, 1, 0},
                         {1, 1, 0, 1},
                         {1, 0, 1, 0},
                       };

        graphColoring(graph,3);
    }
    public static boolean isSafe(int[][] graph,int[] color,int v,int c) {
        for (int i = 0; i < graph.length; i++) {

            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }

        }
        return true;
    }

    public static boolean graphColoringUtil(int[][] graph,int m,int[] color,int v) {
        if (v == graph.length)
            return true;

        for (int c = 1; c <=m ; c++) {
            if (isSafe(graph,color,v,c)) {
                color[v] = c;
//                if (v == graph.length - 1)
//                    return true;
                if (graphColoringUtil(graph,m,color,v+1)) {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }
    public static void graphColoring(int[][] graph,int m) {
        int V = graph.length;

        int[] color = new int[V];
        Arrays.fill(color,0);

        if (!graphColoringUtil(graph,m,color,0)) {
            System.out.println("sol does not exist");
            return;
        }
        printVertexColors(color);
    }

    public static void printVertexColors(int[] color) {
        for (int i = 0; i < color.length; i++) {
            System.out.print(color[i] + " ");
        }
        System.out.println();
    }
}
