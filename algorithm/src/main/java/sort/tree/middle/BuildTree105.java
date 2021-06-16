package sort.tree.middle;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 */
public class BuildTree105 {

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {

        if (preorderLeft > preorderRight) {
            return null;
        }

        int preorderRoot = preorderLeft;

        int inorderRoot = indexMap.get((preorder[preorderRoot]));

        TreeNode root = new TreeNode(preorder[preorderRoot]);

        int sizeLeftSubtree = inorderRoot - inorderLeft;

        root.left = myBuildTree(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);
        root.right = myBuildTree(preorder, inorder, preorderLeft + sizeLeftSubtree + 1,preorderRight, inorderRoot + 1, inorderRight);
        return root;
    }

    private TreeNode myBuildTree1(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int preorderRoot = preorderLeft;
        int inorderRoot = indexMap.get((preorder[preorderRoot]));
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        root.left = myBuildTree1(preorder, inorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft, inorderRoot - 1);

        return root;
    }
}
