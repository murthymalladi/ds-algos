package matrix;

/**
 * Created by dmalladi on 3/2/2020.
 */
public class SegmentTreeMinRangeQuery {
    int[] tree;
    int n;
    public void createSegmentTree(int[] input) {
        n = input.length;
        tree = new int[4*n];

        for (int i = 0; i < tree.length; i++)
            tree[i] = Integer.MAX_VALUE;
            buildMinSegmentTree(input,0,n-1,0);
    }

    public  void buildMinSegmentTree(int[] input,int low,int high,int pos) {
        if (low == high) {
            tree[pos] = input[low];
            return;
        }
        int mid = (low+high)/2;
        buildMinSegmentTree(input,low,mid,2*pos+1);
        buildMinSegmentTree(input,mid+1,high,2*pos+2);
        tree[pos] = Math.min(tree[2*pos+1],tree[2*pos+2]);
    }

    public int rangeMinimumQuery(int low,int high) {
        return rangeMinimumQuery(0,n-1,low,high,0);
    }

    public int rangeMinimumQuery(int low,int high,int start,int end,int pos) {

        if (start <= low && end >= high) {
            return tree[pos];
        }
        if (start > high || end < low) {
            return Integer.MAX_VALUE;
        }

        int mid = (low+high)/2;
        int leftMin = rangeMinimumQuery(low,mid,start,end,2*pos+1);
        int rightMin = rangeMinimumQuery(mid+1,high,start,end,2*pos+2);

        return Math.min(leftMin,rightMin);

    }

    public void updateSegmentTree(int[] input,int index,int delta) {
        input[index] = delta;
        updateSegmentTreeUtil(0,input.length-1,index,delta,0);
    }

    public void updateSegmentTreeUtil(int start,int end,int index,int delta,int pos) {
            if (index < start || index > end) {
                return;
            }

            if (start == end) {
                tree[pos] += delta;
                return;
            }
            int mid = (start+end)/2;
            if (mid <= index) {
                updateSegmentTreeUtil(start,mid,index,delta,2*pos+1);
            }
            else {
                updateSegmentTreeUtil(mid+1,end,index,delta,2*pos+2);
            }

            tree[pos] = Math.min(tree[2*pos+1],tree[2*pos+2]);
    }

    public static void main(String[] args) {

        int input1[] = {-1,2,4,1,7,1,3,2};
        SegmentTreeMinRangeQuery tree = new SegmentTreeMinRangeQuery();
        tree.createSegmentTree(input1);
        //non lazy propagation example
        assert 0 == tree.rangeMinimumQuery( 0, 3);
        assert 1 == tree.rangeMinimumQuery( 1, 5);
        assert -1 == tree.rangeMinimumQuery( 1, 6);
        tree.updateSegmentTree(input1, 2, 1);
        assert 2 == tree.rangeMinimumQuery( 1, 3);
//        tree.updateSegmentTreeRange(input, segTree, 3, 5, -2);
//        assert -1 == tree.rangeMinimumQuery(segTree, 5, 6, input.length);
//        assert 0 == tree.rangeMinimumQuery(segTree, 0, 3, input.length);
    }
}
