package backtracking;

import java.util.Arrays;

/**
 * Created by dmalladi on 9/8/2018.
 */
public class GenerateAllSubSets {
    public static void main(String[] args) {
        int[] set = {1,2,3,4};
       // generateSubSets(set);
        generateSubSetsRecursion(set);
    }

    public static void generateSubSets(int[] set) {
        int n = set.length;
        // 1<<n is the 2^n
        for (int i = 0; i < (1 << n); i++) {

            System.out.print("{");
            for (int j = 0; j < n; j++) {
                if ( (i & (1<<j)) > 0) {
                    System.out.print(set[j]+",");
                }
            }
            System.out.println("}");
        }
    }

    public static void generateSubSetsRecursion(int[] arr) {
        int[] subset = new int[arr.length];
        Arrays.fill(subset,-1);
        helper(arr,subset,0);
    }
    public static void print(int[] set) {
        for (int i = 0; i < set.length; i++) {
            if (set[i] != -1)
            System.out.print(set[i]+" ");
        }
        System.out.println();
    }
    public static void helper(int[] arr,int[] subset,int index) {
        if (index == arr.length) {
            print(subset);
        }
        else {
            subset[index] = -1;
            helper(arr,subset,index+1);
            subset[index] = arr[index];
            helper(arr,subset,index+1);
        }
    }
}
