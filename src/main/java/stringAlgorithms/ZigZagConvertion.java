package stringAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmalladi on 10/18/2018.
 */
public class ZigZagConvertion {
    public static void main(String[] args) {
        String s = "ABCD";
        int rows = 2;
        String output = conversion(s,rows);
        System.out.println(output);
    }

    public static String conversion(String s,int numRows) {
        boolean go = true;
        int count = 0;
        HashMap<Integer,ArrayList<Character>> map = new HashMap<Integer,ArrayList<Character>>();
        ArrayList<Character> list = null;
        for (int i = 0; i < numRows; i++) {
            list = new ArrayList<Character>();
            map.put(i,list);
        }
        for (int i = 0; i < s.length(); i++) {

            if (count == 0) {
                go = true;
            }
            if (count < numRows && go) {
                map.get(count).add(s.charAt(i));
                count++;
            }
            else if (count == numRows) {
                go = false;
                count = count - 2;
            }
            if (!go) {

                map.get(count).add(s.charAt(i));
                if (count == 0) {
                    count++;
                    go = true;
                }
                else {
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            list = map.get(i);
            for (Character ch : list)
                sb.append(ch);
        }
        return sb.toString();
    }
}
