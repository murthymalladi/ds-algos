package segmenttree;

/**
 * Created by dmalladi on 2/16/2020.
 */
public class SegmentTree {
    int[] tree;
    int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        buildSegmentTree(nums,1,0,n-1);
    }

    public void buildSegmentTree(int[] nums,int treeIndex,int low,int high) {
        if (low == high) {
            tree[treeIndex] = nums[low];
            return;
        }

        int mid = low + (high-low)/2;
        buildSegmentTree(nums,2*treeIndex,low,mid);
        buildSegmentTree(nums,2*treeIndex+1,mid+1,high);

        //merge results
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];
    }

    public int queryRangeSum(int i,int j) {
        return querySegmentTree(1,0,n-1,i,j);
    }

    private int querySegmentTree(int treeIndex,int low,int high,int i,int j) {
        if (i == low && j == high)
            return tree[treeIndex];

        int mid = low + (high-low)/2;
        if (i > mid) {
            return querySegmentTree(2*treeIndex+1,mid+1,high,i,j);
        }
        else if (j <= mid) {
            return querySegmentTree(2*treeIndex,low,mid,i,j);
        }

        int leftQuery = querySegmentTree(2*treeIndex,low,mid,i,mid);
        int rightQuery = querySegmentTree(2*treeIndex+1,mid+1,high,mid+1,j);

        //merge queries
        return leftQuery + rightQuery;
    }

    public void updateValue(int i,int val) {
        updateValueSegmentTree(1,0,n-1,i,val);
    }

    private void updateValueSegmentTree(int treeIndex,int low,int high,int arrIndex,int val) {
        if (low == high) {
            tree[treeIndex] = val;
            return;
        }

        int mid = low + (high-low)/2;
        if (arrIndex > mid) {
            updateValueSegmentTree(2*treeIndex+1,mid+1,high,arrIndex,val);
        }
        else if (arrIndex <= mid) {
            updateValueSegmentTree(2*treeIndex,low,mid,arrIndex,val);
        }

        //merge
        tree[treeIndex] = tree[2*treeIndex] + tree[2*treeIndex+1];

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] nums2 = {7,2,7,2,0};
//        SegmentTree st = new SegmentTree(nums);
//        int range = st.queryRangeSum(2,7);
//        System.out.println(range);
//        range = st.queryRangeSum(1,8);
//        System.out.println(range);
//
//        st.updateValue(4,-5);
//        range = st.queryRangeSum(1,8);
//        System.out.println(range);

        SegmentTree st2 = new SegmentTree(nums2);
        st2.updateValue(4,6);
        st2.updateValue(0,2);
        st2.updateValue(0,9);
        int range = st2.queryRangeSum(4,4);
        System.out.println(range);
        st2.updateValue(3,8);
        range = st2.queryRangeSum(0,4);
        System.out.println(range);
        st2.updateValue(4,1);
        range = st2.queryRangeSum(0,3);
        System.out.println(range);
        range = st2.queryRangeSum(0,4);
        System.out.println(range);
        st2.updateValue(0,4);




    }
}
