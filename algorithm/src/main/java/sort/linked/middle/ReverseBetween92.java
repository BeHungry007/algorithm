package sort.linked.middle;

import utils.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 */
public class ReverseBetween92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode ans = pre;
        if (left == right) return head;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode reve = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = reve.next;
            reve.next = reve.next.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return ans.next;



    }
}
