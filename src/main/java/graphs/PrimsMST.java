package graphs;

import java.util.*;

/**
 * Created by dmalladi on 8/15/2018.
 */

public class PrimsMST {


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
    class VertexNode {
        int destination;
        int weight;
        public VertexNode(int destination,int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }
    }

      class Graph {
        private int V;
        private int E;
        LinkedList<VertexNode>[] adjList;
        List<Edge> edges;
        public Graph(int V,int E) {
            this.V = V;
            this.E = E;
            edges = new ArrayList<Edge>();
            adjList = (LinkedList<VertexNode>[]) new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new LinkedList<VertexNode>();
            }

        }

        public void addEdge(int source,int destination) {
            Edge edge = new Edge(source,destination);
            edges.add(edge);
            VertexNode node1 = new VertexNode(destination,0);
            adjList[source].add(node1);
            VertexNode node2 = new VertexNode(source,0);
            adjList[destination].add(node2);
        }

        public void addEdge(int source,int destination,int weight) {
            Edge edge = new Edge(source,destination);
            edges.add(edge);
            VertexNode node1 = new VertexNode(destination,weight);
            adjList[source].add(node1);
            VertexNode node2 = new VertexNode(source,weight);
            adjList[destination].add(node2);
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

          public LinkedList<VertexNode>[] getAdjList() {
              return adjList;
          }

          public List<Edge> getEdges() {
            return edges;
        }
    }

    public static void main(String[] args) {

        PrimsMST mst = new PrimsMST();
        BinaryMinHeap heap = new BinaryMinHeap();

        List<Edge> edges = mst.primsMST(heap);

        for (Edge edge : edges) {
            System.out.println(edge.getSource()+"-> " + edge.getDestination());
        }

    }

    public  Graph buildGraph() {
        Graph graph = new Graph(7,9);

        graph.addEdge(0,1,28);
        graph.addEdge(0,5,10);
        graph.addEdge(1,2,16);
        graph.addEdge(1,6,14);
        graph.addEdge(2,3,12);
        graph.addEdge(3,4,22);
        graph.addEdge(3,6,18);
        graph.addEdge(4,5,25);
        graph.addEdge(4,6,24);

        return graph;

    }



    public  List<Edge> primsMST(BinaryMinHeap heap) {
        Graph graph = buildGraph();
        int v = graph.getV();
        LinkedList<VertexNode>[] adjList = graph.getAdjList();
        VertexWithKey vertexWthKey = null;
        for (int i = 0; i < v; i++) {
            vertexWthKey = new VertexWithKey(i,Integer.MAX_VALUE,-1);
            heap.insertKey(vertexWthKey);
        }
        heap.buildMinHeap();
        List<Edge> result = new ArrayList<Edge>();
        heap.decreaseKey(0,0,0);
        while(!heap.isEmpty()) {
            VertexWithKey minVertex = heap.extractMin();
            if (minVertex.getParent() != -1) {
                result.add(new Edge(minVertex.getParent(),minVertex.getId(),0));
            }
            LinkedList<VertexNode> list = adjList[minVertex.getId()];

            for (VertexNode vertex: list) {
                if (heap.containsId(vertex.getDestination()) &&
                        vertex.getWeight() < heap.getWeight(vertex.getDestination())) {
                        heap.decreaseKey(vertex.getDestination(),minVertex.getId(),vertex.getWeight());
                }
            }

        }
        return result;
    }
}
