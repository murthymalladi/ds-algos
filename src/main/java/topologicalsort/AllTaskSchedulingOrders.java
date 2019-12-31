package topologicalsort;

import java.util.*;

/**
 * Created by dmalladi on 12/18/2019.
 */
class AllTaskSchedulingOrders {
    public static void printOrders(int tasks, int[][] prerequisites) {

        List<Integer> sortedOrder = new ArrayList<>();
        //initialize
        HashMap<Integer,Integer> inDegree = new HashMap<>();
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < tasks; i++){
            inDegree.put(i,0);
            graph.put(i,new ArrayList<Integer>());

        }

        //build graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            inDegree.put(child,inDegree.get(child)+1);
            graph.get(parent).add(child);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer,Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        printAll(graph,inDegree,sources,sortedOrder);
    }

    public static void printAll(HashMap<Integer,List<Integer>> graph,
                                HashMap<Integer,Integer> inDegree,
                                Queue<Integer> sources,List<Integer> sortedOrder
                                ) {
        if (!sources.isEmpty()) {

            for (Integer vertex:sources) {
                sortedOrder.add(vertex);

                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                sourcesForNextCall.remove(vertex);

                List<Integer> children = graph.get(vertex);
                for (int child:children) {
                    inDegree.put(child,inDegree.get(child)-1);
                    if (inDegree.get(child) == 0) {
                        sourcesForNextCall.add(child);
                    }

                }
                printAll(graph,inDegree,sourcesForNextCall,sortedOrder);
                sortedOrder.remove(vertex);
                for (int child:children) {
                    inDegree.put(child,inDegree.get(child)+1);
                }
           }

       }
        if (sortedOrder.size() == inDegree.size()) {
            System.out.println(sortedOrder);
        }


    }

    public static Queue<Integer> cloneQueue(Queue<Integer> sources) {
        Queue<Integer> sourcesForNextCall = new LinkedList<>();
        for (int val: sources) {
            sourcesForNextCall.add(val);
        }
        return sourcesForNextCall;
    }
    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}
