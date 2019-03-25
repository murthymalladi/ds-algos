package bfs;

import java.util.*;

/**
 * Created by dmalladi on 12/29/2018.
 */
public class MinRemoveInvalidParethesis {

    public static void main(String[] args) {
        String input = "()())()";
        //List<String> output = findMinRemoveParentheses(input);
        List<String> output = v2(input);
        for (String s : output) {
            System.out.println(s);
        }


    }

    public static List<String> v2(String s) {
        List<String> res = new ArrayList<>();
        if (s == null)
            return res;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;
        queue.add(s);

        while(!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (isValid(node)) {
                    res.add(node);
                    found = true;
                }
                if (!found) {
                    for (int j = 0; j < node.length(); j++) {
                        if (node.charAt(j) != '(' && node.charAt(j) != ')')
                            continue;
                        else {
                            String temp = node.substring(0,j) + node.substring(j+1);
                            if (!visited.contains(temp)) {
                                queue.add(temp);
                                visited.add(temp);
                            }
                        }
                    }
                }
            }
        }
    return res;
    }

    public static List<String> findMinRemoveParentheses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null)
            return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        boolean found = false;

        while(!queue.isEmpty()) {
            String node = queue.poll();
            if (isValid(node)) {
                res.add(node);
                found = true;
            }
            if (found) continue;

            for (int i = 0; i < node.length(); i++) {
                char c = node.charAt(i);
                if (c != '(' && c != ')') continue;
                else {
                    String t = node.substring(0,i) + node.substring(i+1);
                    if (!visited.contains(t)) {
                        queue.add(t);
                        visited.add(t);
                    }
                }
            }

        }

        return res;
    }

    public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}
