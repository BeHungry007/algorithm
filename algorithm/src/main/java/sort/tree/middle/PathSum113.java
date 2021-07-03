package sort.tree.middle;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSum113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, sum, res, new LinkedList<>());
        return res;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> current) {
        if (root == null) {
            return;
        }
        current.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            // leaf node.
            res.add(new LinkedList<>(current));
            // back track.
            current.remove(current.size() - 1);
            return;
        }

        helper(root.left, sum - root.val, res, current);
        helper(root.right, sum - root.val, res, current);
        // back track.
        current.remove(current.size() - 1);
    }
}
