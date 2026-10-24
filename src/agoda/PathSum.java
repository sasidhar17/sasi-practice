package agoda;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, new ArrayList<>(), 0, target, result);
        return result;
    }

    public void backtrack(TreeNode root, List<Integer> path, int total, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        total += root.val;

        if(total > target) {
            path.removeLast();
            total -= root.val;
        }

        if(root.left == null && root.right == null) {
            if(total == target) {
                result.add(path);
            }
        }
        backtrack(root.left, path, total, target, result);
        backtrack(root.right, path, total, target, result);

        path.removeLast();
    }
}
