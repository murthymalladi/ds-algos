package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmalladi on 8/18/2018.
 */
public class Dijkstra {

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
           // VertexNode node2 = new VertexNode(source,0);
           // adjList[destination].add(node2);
        }

        public void addEdge(int source,int destination,int weight) {
            Edge edge = new Edge(source,destination);
            edges.add(edge);
            VertexNode node1 = new VertexNode(destination,weight);
            adjList[source].add(node1);
        //    VertexNode node2 = new VertexNode(source,weight);
         //   adjList[destination].add(node2);
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

        Dijkstra dijkstra = new Dijkstra();
        BinaryMinHeap heap = new BinaryMinHeap();

        List<VertexWithKey> vertices = dijkstra.dijkstra(heap);

        for (VertexWithKey vertex : vertices) {
            System.out.println(vertex.getId()+"-> " + vertex.getKey());
        }

    }

    public  Graph buildGraph() {
        Graph graph = new Graph(5,10);

        graph.addEdge(0,1,10);
        graph.addEdge(0,3,5);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,2);
        graph.addEdge(2,4,4);
        graph.addEdge(3,1,3);
        graph.addEdge(3,2,9);
        graph.addEdge(3,4,2);
        graph.addEdge(4,0,7);
        graph.addEdge(4,2,6);

        return graph;

    }

    public List<VertexWithKey> dijkstra(BinaryMinHeap heap) {
        Graph graph = buildGraph();
        int v = graph.getV();
        LinkedList<VertexNode>[] adjList = graph.getAdjList();
        VertexWithKey vertexWithKey = null;
        for (int i = 0; i < v; i++) {
            vertexWithKey = new VertexWithKey(i,Integer.MAX_VALUE,-1);
            heap.insertKey(vertexWithKey);
        }

        heap.buildMinHeap();
        // start with 0th vertex
        heap.decreaseKey(0,-1,0);

        List<VertexWithKey> result = new ArrayList<VertexWithKey>();
        LinkedList<VertexNode> list = null;
        while(!heap.isEmpty()) {
            vertexWithKey = heap.extractMin();
            if (vertexWithKey.getParent() != -1) {
               // result.add(new Edge(vertexWithKey.getParent(),vertexWithKey.getId(),0));
                result.add(new VertexWithKey(vertexWithKey.getId(),vertexWithKey.getKey(),vertexWithKey.getParent()) );
            }
            list = adjList[vertexWithKey.getId()];

            for (VertexNode node: list) {
                //relax the adjacent nodes
                int key = vertexWithKey.getKey() + node.getWeight();
                if (heap.containsId(node.getDestination() ) && key < heap.getWeight(node.getDestination())) {
                    heap.decreaseKey(node.getDestination(),vertexWithKey.getId(),key);
                }
            }
        }
        return result;
    }

}
