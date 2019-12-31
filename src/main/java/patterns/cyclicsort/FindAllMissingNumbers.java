package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 9/21/2019.
 */
public class FindAllMissingNumbers {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;

        while(i < nums.length) {
            int j = nums[i]-1;

            if (nums[i] != nums[j]) {
                swap(nums,i,j);
            }
            else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j]-1)
                missingNumbers.add(j+1);
        }

        return missingNumbers;
    }

    public static void swap(int[] nums,int i,int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        List<Integer> missing = FindAllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = FindAllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = FindAllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
