package sort.digui.middle;

import utils.TreeNode;

/**
 * 寻找两个树节点的公共祖先
 */
public class LowestCommonAncestor236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口
        if(root == null || root == p || root ==q)
            return root;
        //去该节点的左子树上找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //去该节点的右子树上找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            //左子树上没有，说明在右子树上
            return right;
        }else if(right == null){
            //右子树上没有，说明在左子树上
            return left;
        }
        //左右均有，说明该节点即为最近公共祖先
        return root;
    }
}
