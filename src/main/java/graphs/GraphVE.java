package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmalladi on 8/11/2018.
 */
class Edge implements Comparable<Edge> {
    private int source;
    private int destination;
    private int weight;
    public Edge() {}
    public Edge(int source,int destination) {
        this.source = source;
        this.destination = destination;
        this.weight = 0;
    }
    public Edge(int source,int destination,int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    public int getDestination() {
        return destination;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
//        return "Edge{" +
//                "source=" + source +
//                ", destination=" + destination +
//                '}';

        return source + "-> " + destination;
    }
}
public class GraphVE {
    private int V;
    private int E;
    LinkedList<Integer>[] adjList;
    List<Edge> edges;
    public GraphVE(int V,int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<Edge>();
        adjList = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

    }

    public void addEdge(int source,int destination) {
        Edge edge = new Edge(source,destination);
        edges.add(edge);
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public void addEdge(int source,int destination,int weight) {
        Edge edge = new Edge(source,destination,weight);
        edges.add(edge);
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
