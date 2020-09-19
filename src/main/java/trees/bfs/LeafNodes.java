package trees.bfs;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dmalladi
 */
public class LeafNodes {
    public static List<Integer> leafNodes(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node to the result if it is a leaf node
                if (currentNode.left == null && currentNode.right == null)
                    result.add(currentNode.data);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Integer> result = LeafNodes.leafNodes(root);
        System.out.println("Level order traversal: " + result);
    }
}
