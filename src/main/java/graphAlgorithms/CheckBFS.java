package graphAlgorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dmalladi on 3/8/2020.
 */
public class CheckBFS {

    public static String bfsTraversal(Graph g,int start) {

        int vertices = g.getVertices();
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                sb.append(" " + node);

                List<Integer> neighbors = g.getAdjList().get(node);
                if (neighbors != null) {
                    for (Integer neighbor : neighbors) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }

                    }
                }

            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);


        System.out.println(bfsTraversal(g, 0));
    }
}
