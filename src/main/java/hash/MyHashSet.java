package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmalladi on 12/6/2018.
 */
public class MyHashSet {
    int mode;
    ArrayList<Integer>[] list;
    public MyHashSet() {
        mode = 10000;
        list = (ArrayList<Integer>[])new ArrayList[mode];
        Arrays.fill(list,null);
    }

    public void add(int key) {
        int y = key%mode;
        if (list[y] == null) {
            ArrayList<Integer> bucket = new ArrayList<Integer>();
            bucket.add(key);
            list[y] = bucket;
        }
        else {
            list[y].add(key);
        }
    }

    public boolean contains(int key) {
        int y = key%mode;
        if (list[y] != null) {
          if (list[y].contains(key))
              return true;
        }
        return false;
    }

    public void remove(int key) {
        int y = key%mode;
        if (list[y] != null) {
            ArrayList<Integer> bucket = list[y];
            if (bucket.contains(key)) {
                Integer val = key;
                bucket.remove(val);
           }
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(23);
        hashSet.add(100);
        hashSet.add(125);
        int val = 100;
        if (hashSet.contains(val)) {
            System.out.println(val +" exist");
        }
        else {
            System.out.println(val +" does not exist");
        }
        hashSet.remove(100);
        if (hashSet.contains(val)) {
            System.out.println(val +" exist");
        }
        else {
            System.out.println(val +" does not exist");
        }
    }
}
