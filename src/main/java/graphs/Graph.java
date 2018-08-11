package graphs;

import java.util.*;

/**
 * Created by dmalladi on 8/1/2018.
 */

public class Graph {
    private int V;

    private LinkedList<Integer>[] adjList;

    public Graph(int V) {
        this.V = V;
        adjList = (LinkedList<Integer>[]) new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

    }

    public int getV() {
        return this.V;
    }

    public LinkedList<Integer>[] getAdjList() {
        return this.adjList;
    }

    public void addEdge(int v,int w) {
        adjList[v].add(w);
    }

    public void printGraph() {

        for (int i = 0; i < V; i++) {
            System.out.println("Adjacency list of vertex "+ i);
            System.out.println(i+"-> "+ adjList[i]);
        }
    }

    /**
     * breadth first search BFS
     * @param s
     */

    public void bfs(int s) {
        int[] visited = new int[this.V];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = 1;

        while(!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s+" ");
            LinkedList<Integer> list = this.adjList[s];

            for (int i = 0; i < list.size(); i++) {
                if (visited[list.get(i)] != 1) {
                        queue.offer(list.get(i));
                    visited[list.get(i)] = 1;
                }
            }
        }
    }

    public void dfs(int source) {

        int[] visited = new int[this.V];
        dfsUtil(visited,source);
    }

    public void dfsUtil(int[] visited,int source) {

        visited[source] = 1;
        System.out.print(source+" ");
        LinkedList<Integer> list = adjList[source];

        for (int i = 0; i < list.size(); i++) {
            if (visited[list.get(i)] != 1) {
                dfsUtil(visited,list.get(i));
            }
        }
    }

    public void dfsWithFinishingTime(int source,int[] visited,Stack<Integer> stack) {

        visited[source] = 1;
        List<Integer> list = adjList[source];

        for (int i = 0; i < list.size(); i++) {
            if (visited[list.get(i)] != 1) {
                dfsWithFinishingTime(list.get(i),visited,stack);
            }
        }
        stack.push(source);
    }

    public  Graph transpose() {
        Graph newGraph = new Graph(this.V);

        for (int i = 0; i < V; i++) {
            LinkedList<Integer> list = getAdjList()[i];

            for (int j = 0; j < list.size(); j++) {
                newGraph.addEdge(list.get(j),i);
            }
        }
        return newGraph;
    }

    public boolean isCyclic() {
        int vertices = getV();
        int[] visited = new int[vertices];
        int[] recStack = new int[vertices];

        Arrays.fill(visited,0);
        Arrays.fill(recStack,0);

        for (int i = 0; i < vertices; i++) {

            if (isCyclicUtil(i,visited,recStack)) {
                return true;
            }
        }
        return false;
    }





    public boolean isCyclicUtil(int source,int[] visited,int[] recStack) {

        if (recStack[source] == 1)
            return true;

        if (visited[source] == 1)
            return false;

        visited[source] = 1;
        recStack[source] = 1;

        LinkedList<Integer> list = adjList[source];

        for (int i = 0; i < list.size(); i++) {
            if (isCyclicUtil(list.get(i),visited,recStack)) {
                return true;
            }
        }
        recStack[source] = 2;
        return false;
    }

    public void dfsWithColor() {
        int vertices = getV();
        int[] color = new int[vertices];
        Arrays.fill(color,0);

        for (int i = 0; i < vertices;i++) {
            if (color[i] == 0) {
                dfsWithColorUtil(i,color);
            }
        }
    }

    public void dfsWithColorUtil(int source,int[] color) {

        color[source] = 1;
        System.out.print(source+" ");
        LinkedList<Integer> list = adjList[source];

        for (int i = 0; i < list.size(); i++) {
            if (color[list.get(i)] == 0) {
                dfsWithColorUtil(list.get(i),color);
            }
        }
        color[source] = 2;
    }


    public static void main(String[] args) {

//        Graph graph = new Graph(5);
//        graph.addEdge(0,2);
//        graph.addEdge(0,3);
//        graph.addEdge(1,0);
//        graph.addEdge(2,1);
//        graph.addEdge(3,4);

        //for cycle

        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        graph.printGraph();

        if (graph.isCyclic()) {
            System.out.println("cyclic graph");
        }
        else {
            System.out.println("not a cyclic graph");
        }

//        System.out.println("\n dfs with color: ");
//        graph.dfsWithColor();
//        System.out.println();
//        graph.dfs(0);
    }

}
