package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author dmalladi
 */
public class StronglyConnectedComponents {

    public static void main(String[] args) {


        Graph graph = new Graph(5);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,0);
        graph.addEdge(2,1);
        graph.addEdge(3,4);

     //   graph.dfs(0);

//        graph.printGraph();
//
//        Graph newGraph = graph.transpose();
//        System.out.println("\n\n\nafter transpose: ");
//        newGraph.printGraph();

        scc(graph);
    }

    public static void scc(Graph graph) {

        Stack<Integer> stack = new Stack<Integer>();

        int vertices = graph.getV();
        int[] visited = new int[vertices];
        Arrays.fill(visited,0);

        for (int i = 0; i < vertices; i++) {
            if (visited[i] != 1) {
                graph.dfsWithFinishingTime(i, visited, stack);
            }
        }

        //transpose the graph
        Graph transposeGraph = graph.transpose();
        System.out.println("\n\nafter transpose: ");
        transposeGraph.printGraph();
        System.out.println();

        // second DFS
        Arrays.fill(visited,0);
        while(!stack.isEmpty()) {
            int s = stack.pop();

            if (visited[s] != 1) {
                transposeGraph.dfsUtil(visited,s);
                System.out.println();
            }

        }

    }




}
