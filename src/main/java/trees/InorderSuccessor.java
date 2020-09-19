package trees;

/**
 * Created by dmalladi on 6/30/2020.
 */
public class InorderSuccessor {

    public static void printInorder(TreeNode root) {
        inorder(root);
        System.out.println();
    }


    public static void inorderSuccessor(TreeNode root,TreeNode prev,TreeNode p) {
        if (root.right != null) {
            inorderSuccessor(root.right,prev,p);
        }

        if (root.data == p.data) {
            if (prev != null) {
                System.out.println(prev.data);
            }
            return;
        }
    }
    private static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
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



    }
}
