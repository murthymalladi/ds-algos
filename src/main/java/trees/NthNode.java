package trees;

/**
 * Created by dmalladi on 6/30/2020.
 */
public class NthNode {

    static int count = 0;
    public static TreeNode nthNode(TreeNode root,int n) {
        return nthNodeUtil(root,n);
    }
    private static TreeNode nthNodeUtil(TreeNode root,int n) {
        if (root == null)
            return root;

        TreeNode leftNode = nthNodeUtil(root.left,n);
        if (leftNode != null)
            return leftNode;
        count++;
        if (count == n) {
            return root;
        }

        TreeNode rightNode = nthNodeUtil(root.right,n);
        if (rightNode != null)
            return rightNode;

        return null;
    }

    private static void printNthNode(TreeNode root,int n) {
        if (root == null)
            return;
        printNthNode(root.left,n);
        count++;
        if (count == n) {
            System.out.println(root.data);
        }
        printNthNode(root.right,n);
    }

    public static void nthNode2(TreeNode root,int n) {
        printNthNode(root,n);
    }





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

//        TreeNode nthNode = nthNode(tree,7);
//        if (nthNode != null)
//            System.out.println(nthNode.data);
//        else
//            System.out.println("null");

        printNthNode(tree,4);

    }
}
