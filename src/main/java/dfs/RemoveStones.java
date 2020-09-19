package dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmalladi on 1/18/2020.
 */
public class RemoveStones {

    public static int removeStones(int[][] stones) {

        if (stones.length == 0)
            return 0;

        //initialize graph
        int n = stones.length;
        int[][] graph = new int[n][n];

        for (int i = 0; i < stones.length; i++) {
            for (int j = i+1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        printGraph(graph);



        Set<Integer> seen = new HashSet<>();

        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (!seen.contains(i)) {
                count++;
                dfs(seen,stones,graph,i);
            }
        }
        return count;

    }

    public static void dfs(Set<Integer> seen, int[][] stones, int[][] graph, int vertex) {
        seen.add(vertex);

        for (int i = 0; i < graph[0].length; i++) {
            if (graph[vertex][i] == 1 && !seen.contains(i) ) {
                dfs(seen,stones,graph,i);
            }
        }
    }

    public static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        int count = removeStones(stones);
        System.out.println(count);
    }
}
