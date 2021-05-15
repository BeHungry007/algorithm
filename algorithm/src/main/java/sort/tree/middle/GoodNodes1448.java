package sort.tree.middle;

import utils.TreeNode;

/**
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 */
public class GoodNodes1448 {

    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = root.val;
        dfs(root, max);
        return count;
    }

    public void dfs(TreeNode node,int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            count++;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);
    }
}
