package sort.tree.middle;

import utils.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList143 {

    /**
     * 1. 先获取到后一半链表的第一个位置；
     * 2. 将后一半链表反转(反转的起点cur, pre = null, next = null)；
     *      2.1 获取反转链表的当前位置cur;
     *      2.2 获取cur的下一个位置next;
     *      2.3 将cur指向pre;
     *      2.4 将cur赋值给pre;
     *      2.5 将next赋值给cur
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow.next, pre = null, next = null;
        slow.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode p1 = head, p2 = pre;
        while (p1 != null && p2 != null) {
            next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = next;
        }
    }
}
