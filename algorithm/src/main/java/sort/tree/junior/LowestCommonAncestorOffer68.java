package sort.tree.junior;

import utils.TreeNode;

/**
 * 两个节点的公共祖先
 */
public class LowestCommonAncestorOffer68 {

    /**
     * 递归算法
     *
     * 1. 先判定当前root为null? 如果为null 则返回null;
     * 2. 判定当前root是不是p或者q节点，如果是，则返回root;
     * 3. 分别取root的左节点和右节点，做递归；
     * 4. 获取递归的返回值：left和right
     *      1. 如果都不为null,则说明p和q匹配到，祖先节点为当前root节点；
     *      2. 如果其中一个为null另外一个不是，则说明不为null的节点为1中的root节点，直接返回即可；
     *      3. 如果都为null，则没有匹配成功，返回null。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}
