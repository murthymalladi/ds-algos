package trees.conversion;

import trees.TreeNode;

/**
 * Created by dmalladi on 7/22/2020.
 */

/*
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}
 */
public class TreeFlatten {

    public static void flatten(TreeNode root) {
        flattenTree(root);
    }

    private static TreeNode flattenTree(TreeNode root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode leftTail = flattenTree(root.left);
        TreeNode rightTail = flattenTree(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rightTail != null ? rightTail : leftTail;
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
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        printTree(root);
        flatten(root);
        System.out.println();
        printTree(root);
    }
}
