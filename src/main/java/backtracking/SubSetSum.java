package backtracking;

import java.util.ArrayList;
import java.util.List;

/** subset sum with exaust search.
 * @author dmalladi
 */
public class SubSetSum {

    public static void main(String[] args) {
        int[] set = {5,10,12,13,15,18};
        int sum = 30;
        List<ArrayList<Integer>> subSetList = subSetSum(set,sum);

        for (ArrayList<Integer> list : subSetList) {
            System.out.println(list);
        }
    }

    public static List<ArrayList<Integer>> subSetSum(int[] set,int sum) {
        int n = set.length;
        List<ArrayList<Integer>> subSetList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list ;

        //(1<<n) == 2^n
        for (int i = 0; i < (1<<n); i++) {
            list = new ArrayList<Integer>();
            int currSum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) > 0) {
                    currSum += set[j];
                    list.add(set[j]);
                }
            }
            if (currSum == sum)
            subSetList.add(list);
        }
        return subSetList;
    }

}
