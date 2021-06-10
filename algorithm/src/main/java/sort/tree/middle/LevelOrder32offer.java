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
        Queue<TreeNode> list = new LinkedList<>(){{add(root);}};
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

    public List<List<Integer>> levelOrderII(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> list = new LinkedList<>(){{add(root);}};
        ArrayList<List<Integer>> ans = new ArrayList<>();
        while (!list.isEmpty()) {
            int count = list.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = list.poll();
                arr.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            ans.add(arr);
        }


        return ans;
    }

}
