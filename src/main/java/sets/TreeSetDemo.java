package sets;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by dmalladi on 10/25/2018.
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);

        System.out.println(set);

        SortedSet<Integer> subSet = set.subSet(1,5);
        System.out.println(subSet);


    }
}
