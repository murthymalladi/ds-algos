package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by dmalladi on 8/8/2018.
 */
public class TopologicalSort {

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.printGraph();
        System.out.println("topological sorting: ");
        topologicalSort(g);

    }

    public static void topologicalSort(Graph graph) {
        int vertices = graph.getV();
        int[] visited = new int[vertices];
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.fill(visited,0);
        for (int i = 0; i < vertices; i++) {
            if (visited[i] != 1) {
                topologicalSortUtil(i,graph.getAdjList(), visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");
        }
   }

    public static void topologicalSortUtil(int source,LinkedList<Integer>[] adjList,int[] visited,Stack<Integer> stack) {

        visited[source] = 1;
        LinkedList<Integer> list = adjList[source];

        for (int i = 0; i < list.size(); i++) {
            if (visited[list.get(i)] != 1) {
                topologicalSortUtil(list.get(i),adjList,visited,stack);
            }
        }
        stack.push(source);
    }
}
