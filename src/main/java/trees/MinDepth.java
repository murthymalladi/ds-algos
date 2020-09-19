package trees;

/**
 * Created by dmalladi on 6/29/2020.
 */
public class MinDepth {

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

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepth(root.right) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minDepth(root.left) + 1;
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        return Math.min(leftMinDepth,rightMinDepth) + 1;
    }

    public static int minDepth2(TreeNode root) {

        if(root==null)
            return 0;

        return depth(root);

    }

    public static int depth(TreeNode root)
    {
        if(root==null)
            return Integer.MAX_VALUE;

        if(root.left==null && root.right==null)
            return 1;

        int l=depth(root.left);
        int r=depth(root.right);

        return 1+Math.min(l,r);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(20);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(9);
        tree.right.left = new TreeNode(15);
        tree.right.left.right = new TreeNode(17);

        System.out.println("inorder:");
        printInorder(tree);

        int minDepth = minDepth2(tree);
        System.out.println(minDepth);

    }
}
