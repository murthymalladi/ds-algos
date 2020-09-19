package trees;

/**
 * Created by dmalladi on 6/26/2020.
 */
public class KthSmallestElementBST {

    public static void printInorder(TreeNode root) {
        inorder(root);
        System.out.println();
    }
    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] nums = new int[2];
        inorder(root,nums,k);

        return nums[1];
    }

    public static void inorder(TreeNode root,int[] nums,int k) {
        if (root == null)
            return;

        inorder(root.left,nums,k);
        if (++nums[0] == k) {
            nums[1] = root.data;
            return;
        }
        inorder(root.right,nums,k);
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(20);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(9);
        tree.right.left = new TreeNode(15);

        System.out.println("inorder:");
        printInorder(tree);

        int val = kthSmallest(tree,3);
        System.out.println(val);

    }


}
