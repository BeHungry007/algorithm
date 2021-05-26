package sort.tree.middle;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上往下打印二叉树的节点
 */
public class LevelOrder32offer {


    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> list = new LinkedList<TreeNode>(){{add(root);}};
        ArrayList<Integer> ans = new ArrayList<>();
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            ans.add(node.val);
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

}
