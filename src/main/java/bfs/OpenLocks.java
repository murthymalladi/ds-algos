package bfs;

import java.util.*;

/**
 * Created by dmalladi on 12/12/2018.
 */
public class OpenLocks {

    public static void main(String[] args) {
        String[] deadends = {"8888"};
        String target = "0009";
        int val = bfs(deadends,target);
        System.out.println(val);
    }

    public static int bfs(String[] deadends,String target) {
        if (target == null || target.length() == 0)
            return -1;
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> seen = new HashSet<>();

        int step = 0;
        Queue<String> queue = new LinkedList<>();

        queue.add("0000");
        seen.add("0000");

        while(queue.size() != 0) {

            int size = queue.size();

            for (int i = 0; i < size;i++) {
                String now = queue.poll();
                if (now.equals(target))
                    return step;

                for (int j = 0; j < now.length(); j++) {
                    int digit = now.charAt(j) - '0';
                    int forward = (digit+1)%10;
                    String temp1 = now.substring(0,j) + forward + now.substring(j+1);
                    if (!seen.contains(temp1) && !deads.contains(temp1)) {
                        queue.add(temp1);
                        seen.add(temp1);
                    }

                    //backward rotation
                    int backword = (digit+9)%10;
                    String temp2 = now.substring(0,j) + backword + now.substring(j+1);
                    if (!seen.contains(temp2) && !deads.contains(temp2)) {
                        queue.add(temp2);
                        seen.add(temp2);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
