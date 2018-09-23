package backtracking;

import java.util.Arrays;

/**
 * Created by dmalladi on 9/9/2018.
 */
public class SubSetSumOptmized {
    public static void main(String[] args) {
        int[] set = {5,10,12,13,15,18};
        int sum = 30;
        int[] t = new int[set.length];
        Arrays.fill(t,0);
        subSetSum(set,t,0,sum,0,0);
     //   subSetSum2(set,t,73,0,30,0,0);

    }

    public static void printsubSet(int[] t,int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(t[i] + " ");
        }
        System.out.println();
    }

    public static void subSetSum(int[] set,int[] t, int currSum,int totalSum,int iteration,int t_size) {
        if (currSum == totalSum) {
            printsubSet(t,t_size);
            return;
        }
        else {
            for (int i = iteration; i < set.length; i++) {
                t[t_size]=set[i];
                subSetSum(set,t,currSum + set[i],totalSum,i + 1,t_size+1);

            }
        }
    }

    public static void subSetSum2(int[] set,int[] result,int totalSum,int currSum,int sum,int result_size,int iteration) {
        for (int i = iteration; i < set.length; i++) {
            //consider s[i]
            currSum = currSum + set[i];
            totalSum = totalSum - set[i];
            result[result_size] = set[i];
            if (currSum == sum) {
                printsubSet(result,result_size+1);
                return;
            }
            subSetSum2(set,result,totalSum,currSum,sum,result_size + 1,i+1);
            //backtrack don't consider set[i]
            currSum = currSum - set[i];
            subSetSum2(set,result,totalSum,currSum,sum,result_size,i+1);
        }
    }

}
