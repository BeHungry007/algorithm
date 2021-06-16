package sort.digui.middle;

import utils.TreeNode;

/**
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 *
 */
public class MaxProduct1339 {

    double ans = Double.MIN_VALUE;
    double allSum;
    double nodeSum;
    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        dfs(root);
        return (int)(ans % (int)(1e9 + 7));
    }

    private double sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    public double dfs(TreeNode node) {
        if (node == null) return 0;
        nodeSum = node.val + dfs(node.left) + dfs(node.right);
        ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
        return nodeSum;
    }

}
