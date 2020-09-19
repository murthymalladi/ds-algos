package graphAlgorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by dmalladi on 3/8/2020.
 */
public class CheckDFS {

    public static String dfsTraversalIterative(Graph g, int start) {
        int vertices = g.getVertices();
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                sb.append(" " + node);
                List<Integer> neighbors = g.getAdjList().get(node);

                for (Integer neighbor : neighbors) {
                    stack.push(neighbor);
                }
            }

        }
        return sb.toString();
    }

    public static String dfsTraversal(Graph g, int start) {
        int vertices = g.getVertices();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);

        StringBuilder sb = new StringBuilder();

        dfs(g,visited,start,sb);

        return sb.toString();
    }

    public static void dfs(Graph g,boolean[] visited,int start,StringBuilder result) {

        if (start < g.getVertices() && !visited[start]) {
            System.out.println(start);
            result.append(" "+ start);
            visited[start] = true;

            List<Integer> neighbors = g.getAdjList().get(start);

            for (Integer neighbor : neighbors) {
                dfs(g,visited,neighbor,result);
            }

        }
    }

    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);

        g.print();
        System.out.println(dfsTraversal(g, 0));
        System.out.println(dfsTraversalIterative(g,0));
    }
}
