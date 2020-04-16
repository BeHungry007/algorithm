package middleDemo.Demo100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//二叉树的前序遍历
public class Demo144 {

    @Test
    public void test01(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        Integer poll = list.pollLast();
        System.out.println(poll);
    }

    public List<Integer> pr(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                output.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else{
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrList = new LinkedList<>();
        LinkedList<TreeNode> treeList = new LinkedList<>();
        if (root == null) return arrList;
        treeList.add(root);
        while (!treeList.isEmpty()) {
            TreeNode treeNode = treeList.pollLast();
            arrList.add(treeNode.val);
            if (treeNode.right != null) {
                treeList.add(treeNode.right);
            }
            if (treeNode.left != null) {
                treeList.add(treeNode.left);
            }
        }
        return arrList;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
