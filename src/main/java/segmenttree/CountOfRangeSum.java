package segmenttree;

/**
 * Created by dmalladi on 2/17/2020.
 */

class CountOfRangeSum {
    int[] tree;
    int n;
    int count = 0;
    public CountOfRangeSum() {

    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        n = nums.length;
        tree = new int[n*4];
        buildTree(nums,1,0,n-1);
        query(1,0,n-1,lower,upper);
        return count;
    }

    public void query(int treeIndex,int low,int high,int lower,int upper) {
        if (low == high) {
            if (lower <= tree[treeIndex] && tree[treeIndex] <= upper) {

                count++;
                System.out.println("1:" + count);
            }
            return;
        }

        if (lower <= tree[treeIndex] && tree[treeIndex] <= upper) {
            count++;
            System.out.println("2:" + count);
        }
        int mid = low + (high-low)/2;
        query(2*treeIndex,low,mid,lower,upper);
        query(2*treeIndex+1,mid+1,high,lower,upper);
    }

    public void buildTree(int[] nums,int treeIndex,int low,int high) {
        if (low == high) {
            tree[treeIndex] = nums[low];
            return;
        }

        int mid = low + (high-low)/2;
        buildTree(nums,2*treeIndex,low,mid);
        buildTree(nums,2*treeIndex+1,mid+1,high);
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];
    }

    public static void main(String[] args) {
        CountOfRangeSum cs = new CountOfRangeSum();
        int[] nums = {0,-3,-3,1,1,2};
        int lower = 3;
        int upper = 5;
        int val = cs.countRangeSum(nums,lower,upper);
        System.out.println(val);
    }
}
