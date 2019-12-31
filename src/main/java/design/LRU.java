package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by dmalladi on 8/31/2019.
 */
public class LRU {

    HashMap<Integer,Integer> map;
    int capacity;
    Deque<Integer> deq;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        deq = new LinkedList<>();
    }


    public static void main(String[] args) {
        int capacity = 2;
        LRU cache = new LRU(capacity);
        cache.put(2,1);
        cache.put(1,1);
        int val = cache.get(2);
        System.out.println(val);
        cache.put(4,1);
         val = cache.get(1);
        System.out.println(val);
         val = cache.get(2);
        System.out.println(val);
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            deq.remove(key);
            deq.addFirst(key);
            return map.get(key);
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (map.size() == capacity) {
            if (!deq.isEmpty()) {
                int leastRecentKey = deq.peekLast();
                map.remove(leastRecentKey);
                map.put(key,value);
                deq.addFirst(key);
                deq.removeLast();
            }
        }
        else {
            map.put(key,value);
            deq.remove(key);
            deq.addFirst(key);

        }
    }

}
