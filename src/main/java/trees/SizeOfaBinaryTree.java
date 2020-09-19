package trees;

import java.util.Stack;

/**
 * Created by dmalladi on 6/26/2020.
 */
public class SizeOfaBinaryTree {

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

    public static int size(TreeNode root) {
        if (root == null)
            return 0;

        // inorder size(root.left) + 1 + size(root.right)
        // preorder 1 + size(root.left) + size(root.right)
        // postorder size(root.left) + size(root.right) + 1
        return size(root.left) + 1 + size(root.right);
    }

    public static int iterativeSize(TreeNode root) {

        int count = 0;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            root = root.right;
        }
        return count;
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

        int size = iterativeSize(tree);
        System.out.println(size);

    }

}
