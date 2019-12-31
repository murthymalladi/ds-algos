package patterns.cyclicsort;

/**
 * Created by dmalladi on 9/21/2019.
 */
public class FindMissingNumber {

    public static int findMissingNumber(int[] nums) {
        // TODO: Write your code here
        int i = 0;
        while(i < nums.length) {

            if (nums[i] < nums.length && nums[i] == i)
                i++;
            else if(nums[i] < nums.length) {
                swap(nums,i,nums[i]);
            }
            else {
                i++;
            }
        }
        for (int j = 0;j < nums.length; j++) {
            if (j != nums[j])
                return j;
        }
        return -1;
    }

    public static void swap(int[] nums,int i,int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        System.out.println(FindMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(FindMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
