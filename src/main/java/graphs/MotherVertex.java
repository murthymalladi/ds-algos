package graphs;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author dmalladi
 */
public class MotherVertex {

    public static void main(String[] args) {

        Graph graph = new Graph(5);

//        graph.addEdge(0,1);
//        graph.addEdge(0,2);
//        graph.addEdge(1,3);
//        graph.addEdge(4,1);
//        graph.addEdge(5,2);
//        graph.addEdge(5,6);
//        graph.addEdge(6,4);
//        graph.addEdge(6,0);

        graph.addEdge(0,3);
        graph.addEdge(0,2);
        graph.addEdge(1,0);
        graph.addEdge(2,1);
        graph.addEdge(3,4);


        graph.printGraph();
        motherVertex(graph);
     //   int vertex = motherVertex(graph);
     //   System.out.println("mother vertex: "+ vertex);

    }

    public static void motherVertex(Graph graph) {

        LinkedList<Integer>[] adjList = graph.getAdjList();
        int[] count = new int[1];
        int[] visited = new int[graph.getV()];
        count[0] = 0;
        for (int i = 0; i < graph.getV(); i++) {
            count[0] = 0;
            Arrays.fill(visited,0);
            dfs(adjList,visited,count,i);
            if (count[0] == graph.getV()) {
               // return i;
                System.out.println("mother vertex: " + i);
            }
        }

       // return -1;
    }

    public static void dfs(LinkedList<Integer>[] adjList,int[] visited,int[] count, int source) {
        visited[source] = 1;
        count[0] += 1;
        LinkedList<Integer> list = adjList[source];
        for (int i = 0; i < list.size(); i++) {
            if (visited[list.get(i)] != 1) {
                dfs(adjList,visited,count,list.get(i));
            }
        }
    }
}
