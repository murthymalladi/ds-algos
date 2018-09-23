package backtracking;

import java.util.Arrays;

/**
 * Created by dmalladi on 9/23/2018.
 */
public class HamiltonianCycle {
    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0},
        };

        int graph2[][] = {{0, 1, 0, 1, 0},
                          {1, 0, 1, 1, 1},
                          {0, 1, 0, 0, 1},
                          {1, 1, 0, 0, 1},
                          {0, 1, 1, 1, 0},
                        };

        hamiltonianCycle(graph2);

    }

    public static void hamiltonianCycle(int[][] graph) {
        int vertices = graph.length;
        int path[] = new int[vertices];
        Arrays.fill(path,-1);

        hamiltonianCycleUtil(graph,path,0);

    }

    public static boolean isSafe(int[][] graph,int[] path,int index,int vertex) {

        if (index == 0)
            return true;
        int prevVertex = path[index - 1];
        if (prevVertex == vertex) {
            return false;
        }
        if (graph[prevVertex][vertex] != 1) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            if (path[i] == vertex)
                return false;
        }

        return true;
    }

    public static boolean hamiltonianCycleUtil(int[][] graph,int[] path,int index) {
        if (index == graph.length) {

            if (graph[path[0]][path[index - 1]] == 1) {
                printPath(path);
                return true;
            }
            else {
                return false;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            //assign vertex to the path
            if (isSafe(graph,path,index,i)) {
                path[index] = i;
                hamiltonianCycleUtil(graph,path,index+1);
            }
       }
       return false;
    }

    public static void printPath(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}
