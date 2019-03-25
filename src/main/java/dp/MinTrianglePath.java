package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmalladi on 10/25/2018.
 */
public class MinTrianglePath {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>(Arrays.asList(3)));
        list.add(new ArrayList<Integer>(Arrays.asList(6,4)));
        list.add(new ArrayList<Integer>(Arrays.asList(5,2,7)));
        list.add(new ArrayList<Integer>(Arrays.asList(9,1,8,6)));

        int length = minTrianglePath2(list);
        System.out.println(length);


    }

    public static int minTrianglePath(List<List<Integer>> triangle) {
        int levels = triangle.size();
        int[][] dp = new int[levels][levels];
        for (int i = 0; i < triangle.get(levels-1).size(); i++) {
            dp[levels-1][i] = triangle.get(levels-1).get(i);
        }

        for (int l = levels-2; l >= 0; l--) {
            for (int i = 0; i <=l; i++) {
                dp[l][i] = Math.min(dp[l+1][i],dp[l+1][i+1]) + triangle.get(l).get(i);
            }
        }

        return dp[0][0];
    }

    public static int minTrianglePath2(List<List<Integer>> triangle) {
        int levels = triangle.size();
        int dp[] = new int[levels];
        for (int i = 0; i < triangle.get(levels-1).size(); i++)
            dp[i] = triangle.get(levels-1).get(i);

        for (int l = levels-2; l >= 0; l--) {
            for (int i = 0; i <= l; i++) {
                dp[i] = Math.min(dp[i],dp[i+1]) + triangle.get(l).get(i);
            }
        }

        return dp[0];
    }

}
