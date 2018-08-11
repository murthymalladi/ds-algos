package graphs;

import java.util.*;

/**
 * Created by dmalladi on 8/11/2018.
 */

class SubSet {
    int parent;
    int rank;
}

public class KruskalMST {

    public static void main(String[] args) {
        GraphVE graph = buildGraph();
        SubSet[] disJointSet = new SubSet[graph.getV()];

        for (int i = 0; i < graph.getV(); i++) {
            SubSet subSet = new SubSet();
            subSet.parent = i;
            subSet.rank = 0;
            disJointSet[i] = subSet;
        }

        KruskalMST kruskalMst = new KruskalMST();
        kruskalMst.mst(graph,disJointSet);


    }

    public static GraphVE buildGraph() {
        GraphVE graph = new GraphVE(4,6);

        graph.addEdge(0,1,10);
        graph.addEdge(0,2,6);
        graph.addEdge(0,3,5);
        graph.addEdge(2,3,4);
        graph.addEdge(1,3,15);

        return graph;

    }

    public int findSet(SubSet[] set,int v) {
        int parent = set[v].parent;
        if (parent == v) {
            return parent;
        }
        parent = findSet(set,parent);
        return parent;
    }

    public boolean union(SubSet[] set,int u,int v) {
        int parent1 = findSet(set,u);
        int parent2 = findSet(set,v);

        //both belong to same set
        if (parent1 == parent2) {
            return false;
        }

        if (set[parent1].rank > set[parent2].rank) {
            set[parent2].parent = parent1;
        }
        else if (set[parent1].rank < set[parent2].rank) {
            set[parent1].parent = parent2;
        }
        else {
            set[parent1].rank += 1;
            set[parent2].parent = parent1;
        }
        return true;
    }

    public void mst(GraphVE graph,SubSet[] disJointSet) {

        List<Edge> edges = graph.getEdges();
        Collections.sort(edges);
        Edge edge = null;
       // Edge[] result = new Edge[graph.getV() - 1];
        ArrayList<Edge> result = new ArrayList<Edge>();
        for (int i = 0; i < edges.size(); i++) {
            edge = edges.get(i);
            int vertex1 = edge.getSource();
            int vertex2 = edge.getDestination();
            int parent1 = findSet(disJointSet,vertex1);
            int parent2 = findSet(disJointSet,vertex2);
            //if not a cycle
            if (parent1 != parent2) {
                result.add(edge);
                union(disJointSet,vertex1,vertex2);
            }
        }

        for (Edge edge1: result) {
            System.out.println(edge1);
        }

    }
}
