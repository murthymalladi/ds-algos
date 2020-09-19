package trees;

public class TreeTraversals {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(20);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(15);

        System.out.println("inorder:");
        printInorder(tree);
        System.out.println("postorder:");
        printPostOrder(tree);
        System.out.println("preorder:");
        printPreOrder(tree);

    }

    public static void printInorder(TreeNode root) {
        inorder(root);
        System.out.println();
    }

    public static void printPostOrder(TreeNode root) {
        postOrder(root);
        System.out.println();
    }

    public static void printPreOrder(TreeNode root) {
        preOrder(root);
        System.out.println();
    }

    private static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
