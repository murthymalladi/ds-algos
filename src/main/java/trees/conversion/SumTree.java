package trees.conversion;

import trees.TreeNode;

/**
 * Created by dmalladi on 7/22/2020.
 */
public class SumTree {


    public static int sumTree(TreeNode root) {
        if (root == null)
            return 0;
        int val = root.data;
        root.data = sumTree(root.left) + sumTree(root.right);
        return root.data + val;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data+" ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);


        printTree(root);
        sumTree(root);
        System.out.println();
        printTree(root);
    }
}
