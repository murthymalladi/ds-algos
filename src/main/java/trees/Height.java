package trees;

/**
 * Created by dmalladi on 6/29/2020.
 */
public class Height {

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

    public static int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight < rightHeight)
            return rightHeight + 1;
        else
            return leftHeight+1;
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

        int ht = height(tree);
        System.out.println(ht);

    }
}
