package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by dmalladi on 2/2/2020.
 */
public class strobogrammaticInRange {

    public static int strobogrammaticInRange(String low, String high) {

        int n1 = low.length();
        int n2 = high.length();
        HashSet<String> result = new HashSet<>();
        for (int i = n1; i <= n2; i++) {
            List<String> res = helper(i,i);
            result.addAll(res);
        }
        int count = 0;

        for (String lowSet : result) {
            if (inRange(lowSet,low,high))
                count++;
        }



        return count;
    }

    public static boolean inRange(String s,String low,String high) {
        if (s.length() < low.length())
            return false;
        else if (s.length() == low.length()) {
            if (low.compareTo(s) <= 0) {
                if (s.length() > high.length())
                    return false;
                if (s.length() < high.length())
                    return true;
                return high.compareTo(s) >= 0;
            }

        }
        else if (s.length() > low.length()){
            if (s.length() > high.length())
                return false;
            if (s.length() < high.length())
                return true;
            return high.compareTo(s) >= 0;
        }
        return false;
    }

    public static List<String> helper(int n,int val) {
        if (n == 0) {
            return Arrays.asList("");
        }
        if (n == 1) {
            return Arrays.asList("0","1","8");
        }

        List<String> result = helper(n-2,val);
        List<String> temp = new ArrayList<>();

        for (String num : result) {
            if (n != val) {
                temp.add("0"+num+"0");
            }
            temp.add("1"+num+"1");
            temp.add("6"+num+"9");
            temp.add("8"+num+"8");
            temp.add("9"+num+"6");
        }

        return temp;
    }

    public static void main(String[] args) {
        String low = "50";
        String high = "100000000000000";

        int count = strobogrammaticInRange(low,high);
        System.out.println(count);
    }
}
