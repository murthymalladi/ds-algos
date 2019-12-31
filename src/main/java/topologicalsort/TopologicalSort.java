package topologicalsort;

/**
 * Created by dmalladi on 12/17/2019.
 */
import java.util.*;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        // TODO: Write your code here
        HashMap<Integer,Integer> inDegree = new HashMap<>();
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        // Initialise
        for (int i = 0; i < vertices;i++) {
            inDegree.put(i,0);
            List<Integer> list = new ArrayList<>();
            graph.put(i,list);
        }
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            inDegree.put(child,inDegree.get(child)+1);
            List<Integer> list2 = graph.get(parent);
            list2.add(child);
            graph.put(parent,list2);

        }
        Queue<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer,Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }

        }

        while(!queue.isEmpty()) {
            int val = queue.poll();
            sortedOrder.add(val);
            List<Integer> list3 = graph.get(val);
            for  (Integer i : list3) {
                inDegree.put(i,inDegree.get(i)-1);
                if (inDegree.get(i) == 0)
                    queue.add(i);
            }
        }

        if (sortedOrder.size() != vertices) {
            return new ArrayList<Integer>();
        }

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
                new int[] { 2, 1 }, new int[] { 3, 1 } });
        System.out.println(result);

        result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
                new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
        System.out.println(result);
    }
}