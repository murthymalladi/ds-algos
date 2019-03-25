package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmalladi on 12/29/2018.
 */
public class CourseSchedule2 {
    static int WHITE = 1;
    static int GRAY = 1;
    static int BLACK = 1;

    boolean isPossible;
    Map<Integer,Integer> colors;
    Map<Integer,List<Integer>> adjList;
    List<Integer> topologicalSort;

    private void init(int numCourses) {
        colors = new HashMap<Integer,Integer>();
        adjList = new HashMap<Integer,List<Integer>>();
        topologicalSort = new ArrayList<Integer>();
        this.isPossible = true;
    }

    public void dfs(int node) {
        if (!this.isPossible)
            return;

        colors.put(node,GRAY);

        for (Integer neighbor : adjList.getOrDefault(node,new ArrayList<Integer>())) {
            if (colors.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (colors.get(neighbor) == GRAY) {
                this.isPossible = false;
            }
        }
        colors.put(node,BLACK);
        topologicalSort.add(0,node);
    }

    public int[] findOrder(int numCourses,int[][] prerequisites) {

        init(numCourses);
        //create adj List representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int source = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(source,new ArrayList<Integer>());
            list.add(dest);
            adjList.put(source,list);
        }

        //if there is a unprocessed node do dfs,
        for (int i = 0; i < numCourses; i++) {
            if (colors.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;
        if (isPossible) {
            order = new int[topologicalSort.size()];
            for (int i = 0; i < topologicalSort.size(); i++)
                order[i] = topologicalSort.get(i);
        }
        else {
            order = new int[0];
        }

        return order;
    }
}
