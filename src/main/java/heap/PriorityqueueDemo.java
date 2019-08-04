package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by dmalladi on 5/26/2019.
 */
public class PriorityqueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(4);
        pq.add(6);
        pq.add(1);
        pq.add(5);
        Iterator<Integer> iter = pq.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("peek of pq: " + pq.peek());
        System.out.println("poll operation on pq: " + pq.poll());

    }
}
