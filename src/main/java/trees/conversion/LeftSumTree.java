package trees.conversion;

import trees.TreeNode;

/**
 * Created by dmalladi on 7/26/2020.
 */
public class LeftSumTree {

    public static int update(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;

        int leftSum = update(root.left);
        int rightSum = update(root.right);

        root.data = root.data + leftSum;

        return root.data + rightSum;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data+" ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);


        printTree(root);
       update(root);
        System.out.println();
        printTree(root);
    }
}
