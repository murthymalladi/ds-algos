package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmalladi on 11/4/2018.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        printAllCombinationSums(arr,target);
//        if (isCombinationSumExistDP(arr,target)) {
//            System.out.println("exist");
//        }
//        else {
//            System.out.println("does not exist");
//        }
    }

    public static boolean combinationSum(int[] arr,int target) {
        List<Integer> list = new ArrayList<Integer>();
        return isCombinationSumExist(arr,arr.length,target);
    }

    public static boolean isCombinationSumExist(int[] arr,int length,int target) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (length == 0 && target > 0)
            return false;

        return isCombinationSumExist(arr,length,target - arr[length-1]) ||
                isCombinationSumExist(arr,length-1,target);
   }

   public static void printAllCombinationSums(int[] arr,int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        printAllCombinationSumsUtil(arr,target,0,result,list);

        for (List<Integer> list1: result) {
            System.out.println(list1);
        }
   }

   public static void printAllCombinationSumsUtil(int[] arr,
                                   int target,int start, List<List<Integer>> result,List<Integer> list) {
       if (target == 0) {

           ArrayList<Integer> temp = new ArrayList<Integer>();
           temp.addAll(list);
            result.add(temp);
           return ;
       }

       for (int i = start;i < arr.length; i++) {
           if (target < arr[i])
               return;
           list.add(arr[i]);
           printAllCombinationSumsUtil(arr,target - arr[i],i,result,list);
           list.remove(list.size()-1);
       }
   }

   public static boolean isCombinationSumExistDP(int[] arr,int target) {
        int length = arr.length;
        boolean[][] dp = new boolean[target+1][length+1];

        //base cases
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = true;
                }
                if (j == 0 && i > 0)
                    dp[i][j] = false;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= arr[j-1]) {
                    dp[i][j] = dp[i][j] || dp[i-arr[j-1]][j];
                }

            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[target][length];
   }
}
