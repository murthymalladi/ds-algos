package patterns.topk;

import java.util.*;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class KClosestPointsToOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<Point> maxHeap = new PriorityQueue<Point>(new Comparator<Point>() {
            public int compare(Point p1,Point p2) {
                int a = p1.x*p1.x + p1.y*p1.y;
                int b = p2.x*p2.x + p2.y+p2.y;
                return b-a;
            }
        });

        for (int i = 0; i < k; i++)
            maxHeap.add(points[i]);

        for (int i = k; i < points.length; i++) {
            Point p1 = maxHeap.peek();
            Point p2 = points[i];
            if (p1.x*p1.x + p1.y*p1.y > p2.x*p2.x+p2.y*p2.y) {
                maxHeap.poll();
                maxHeap.add(p2);
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}
