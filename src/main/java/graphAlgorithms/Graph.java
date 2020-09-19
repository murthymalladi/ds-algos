package graphAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 3/8/2020.
 */
public class Graph {

    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            List<Integer> list = new ArrayList<>();
            this.adjList.add(list);
        }
    }

    public int getVertices() {
        return this.vertices;
    }

    public List<List<Integer>> getAdjList() {
        return this.adjList;
    }

    public void addEdge(int source,int destination) {
        this.adjList.get(source).add(destination);
    }

    public void print() {

        for (int i = 0; i < this.vertices; i++) {

            List<Integer> list = adjList.get(i);
            System.out.print("|" + i + "| => ");
            for (Integer node : list) {
                System.out.print("[" + node + "] -> ");
            }
            System.out.println("null");
        }
    }
}
