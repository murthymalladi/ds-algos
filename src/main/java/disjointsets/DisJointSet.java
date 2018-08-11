package disjointsets;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmalladi on 8/11/2018.
 */
class DisJointNode {
    public int data;
    public int rank;
    public DisJointNode parent;
}
public class DisJointSet {
    private Map<Integer,DisJointNode> map = new HashMap<Integer,DisJointNode>();

    public DisJointSet(){}

    public void makeSet(int data) {
        DisJointNode node = new DisJointNode();
        node.data = data;
        node.rank = 0;
        node.parent = node;
        map.put(data,node);
    }

    public boolean union(int data1,int data2) {
        DisJointNode parent1 = findSet(data1);
        DisJointNode parent2 = findSet(data2);

        if (parent1.data == parent2.data) {
            return false;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank += parent2.rank;
            parent2.parent = parent1;
        }
        else {
            parent2.rank += parent1.rank;
            parent1.parent = parent2;
        }
        return true;
    }

    public DisJointNode findSet(int data) {
        DisJointNode node = map.get(data);
        return findSet(node);

    }

    public DisJointNode findSet(DisJointNode node) {
        DisJointNode parent = node.parent;
        if (parent == node) {
            return parent;
        }
        parent = findSet(parent);
        return parent;
    }

    public static void main(String[] args) {
        DisJointSet dis = new DisJointSet();

        dis.makeSet(1);
        dis.makeSet(2);
        dis.makeSet(3);
        dis.makeSet(4);
        dis.makeSet(5);
        dis.makeSet(6);
        dis.makeSet(7);

        dis.union(1, 2);
        dis.union(2, 3);
        dis.union(4, 5);
//        dis.union(6, 7);
//        dis.union(5, 6);
//        dis.union(3, 7);

        System.out.println(dis.findSet(3).data);
//        System.out.println(dis.findSet(2).data);
//        System.out.println(dis.findSet(3).data);
//        System.out.println(dis.findSet(4).data);
//        System.out.println(dis.findSet(5).data);
//        System.out.println(dis.findSet(6).data);
//        System.out.println(dis.findSet(7).data);


    }

}
