package sort.linked.middle;

import utils.ListNode;
import utils.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class sortedListToBST109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode mid = this.findMiddle(head);
        TreeNode node = new TreeNode(mid.val);
        if(head == mid)
            return node;
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
    public ListNode findMiddle(ListNode node){
        if(node == null)
            return null;
        ListNode pre = null;
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null)
            pre.next = null;
        return slow;
    }
}
