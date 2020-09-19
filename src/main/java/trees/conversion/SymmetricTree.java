package trees.conversion;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dmalladi on 7/22/2020.
 */
public class SymmetricTree {

    public static boolean isSymmetry(TreeNode root) {
        return isMirror(root,root);
    }


    public static boolean isSymmetryIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null)
                return false;
            if (node1.data != node2.data)
                return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    private static boolean isMirror(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return root1.data == root2.data && isMirror(root1.left,root2.right)
                && isMirror(root1.right,root2.left);
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

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        printTree(root);
        if (isSymmetry(root)) {
            System.out.println("symmetry");
        }
        else {
            System.out.println("not a symmetry");
        }


    }
}
