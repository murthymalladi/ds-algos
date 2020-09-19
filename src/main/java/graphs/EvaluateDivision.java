package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmalladi on 1/17/2020.
 */

class Node {
    String val;
    Map<Node,Double> adjNodes;
    int state;

    public Node(String val) {
        this.val = val;
        adjNodes = new HashMap<>();
        state = 0;
    }
}

class WtGraph{
    Map<String,Node> nodes;
    public WtGraph() {
        nodes = new HashMap<>();
    }
    public void resetStates() {
        for (String key : nodes.keySet()) {
            nodes.get(key).state = 0;
        }
    }

    public void buildGraph(List<List<String>> equations, double[] values) {

        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String first = list.get(0);
            String second = list.get(1);
            if (!nodes.containsKey(first))
                nodes.put(first,new Node(first));
            if (!nodes.containsKey(second))
                nodes.put(second,new Node(second));
            nodes.get(first).adjNodes.put(nodes.get(second),values[i]);
            nodes.get(second).adjNodes.put(nodes.get(first),1.0/values[i]);
        }
    }
}
public class EvaluateDivision {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        WtGraph graph = new WtGraph();
        graph.buildGraph(equations,values);
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            Node source = graph.nodes.get(list.get(0));
            Node destination = graph.nodes.get(list.get(1));
            results[i] = dfs(source,destination,1);
            graph.resetStates();
        }

        return results;
    }

    public static double dfs(Node source,Node destination,double prod) {

        if (source == null || destination == null)
            return -1;

        if (source.val.equals(destination.val))
            return prod;

        source.state = 1;

        for (Map.Entry<Node,Double> entry : source.adjNodes.entrySet()) {
            Node temp = entry.getKey();
            if (temp.state == 0) {
                double cand = dfs(temp,destination,prod * entry.getValue());
                if (cand != -1)
                    return cand;
            }
       }
        source.state = 2;
        return -1;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();

        List<String> equation1 = new ArrayList<>();
        List<String> equation2 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");

        equation2.add("b");
        equation2.add("c");
        equations.add(equation1);
        equations.add(equation2);

        List<String> query1 = new ArrayList<>();
        List<String> query2 = new ArrayList<>();
        List<String> query3 = new ArrayList<>();
        List<String> query4 = new ArrayList<>();
        List<String> query5 = new ArrayList<>();

        query1.add("a");
        query1.add("c");

        query2.add("b");
        query2.add("a");

        query3.add("a");
        query3.add("e");

        query4.add("a");
        query4.add("a");

        query5.add("x");
        query5.add("x");

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);


        double[] vals = calcEquation(equations,values,queries);

        for (int i = 0; i < vals.length; i++)
            System.out.print(vals[i] +" ");



    }
}
