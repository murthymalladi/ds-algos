package trees.conversion;

import trees.TreeNode;

/**
 * Created by dmalladi on 7/22/2020.
 */
public class TreeFlattenIterative {

    public static void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode node = root;

        while (node != null) {

            // If the node has a left child
            if (node.left != null) {

                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move on to the right side of the tree
            node = node.right;
        }


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
