package sort.arrayTest.junior;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder103 {

    /**
     * 1. 使用flag来判定是不是该数据是不是需要从右向左；
     *      true, 则正常的将数据插入数组最后；
     *      false,将数据插入到头位置。
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> qu = new LinkedList<>();
        boolean flag = true;
        qu.offer(root);
        while (!qu.isEmpty()) {
            Integer cnt = qu.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                TreeNode temp = qu.poll();
                if (temp.left != null) qu.offer(temp.left);
                if (temp.right != null) qu.offer(temp.right);
                if (flag) {
                    level.add(temp.val);
                } else {
                    level.add(0, temp.val);
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}














