package permutations;

/**
 * Created by dmalladi on 12/28/2019.
 */
public class NextPErmutation {

    public static void nextPermutation(int[] nums) {

        if (nums.length == 0)
            return;
        int i;
        for (i = nums.length-2; i>=0; i--) {
            if (nums[i] < nums[i+1])
                break;
        }

        if (i == -1) {
            reverse(nums,0,nums.length);
        }
        else {
            int j = i;
            int k = i+1;
            i = i+1;
            while(i < nums.length) {
                if (nums[i] > nums[j] && nums[i] <= nums[k]) {
                    k = i;
                }
                i++;
            }
            swap(nums,j,k);
            reverse(nums,j+1,nums.length);
        }
    }


    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums,int index,int n) {
        int i = index;
        int j = n-1;

        while(i < j) {
            swap(nums,i,j);
            i++;j--;
        }

    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        nextPermutation(arr);
        for (int i = 0; i < arr.length; i++)
           System.out.print(arr[i]+" ");
    }
}
