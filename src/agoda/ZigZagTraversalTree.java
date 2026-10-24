package agoda;

import java.util.*;

public class ZigZagTraversalTree {
    public List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    currentList.addLast(node.val);
                } else {
                    currentList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(currentList);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
