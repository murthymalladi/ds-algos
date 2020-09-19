package trees.conversion;

import trees.TreeNode;

/**
 * Created by dmalladi on 7/26/2020.
 */
public class FlipTree {

    public static TreeNode flipTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode flipRoot = flipTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return flipRoot;
    }

    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data+" ");
            printTree(root.right);
        }
    }

    public static TreeNode flipTreeIterative(TreeNode root)
    {
        // Initialization of pointers
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        // Iterate through all left nodes
        while(curr != null)
        {
            next = curr.left;

            // Swapping nodes now, need
            // temp to keep the previous
            // right child

            // Making prev's right
            // as curr's left child
            curr.left = temp;

            // Storing curr's right child
            temp = curr.right;

            // Making prev as curr's
            // right child
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        printTree(root);
        TreeNode flipRoot = flipTreeIterative(root);
        System.out.println();
        printTree(flipRoot);
    }
}
