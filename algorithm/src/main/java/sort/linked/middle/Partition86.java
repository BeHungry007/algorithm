package sort.linked.middle;

import utils.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 */
public class Partition86 {

    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode moreHead = new ListNode(0);

        if(head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode curLess = lessHead;
        ListNode curMore = moreHead;

        while(cur != null) {
            if(cur.val < x) {
                curLess.next = new ListNode(cur.val);
                curLess = curLess.next;
                cur = cur.next;
            } else {
                curMore.next = new ListNode(cur.val);
                curMore = curMore.next;
                cur = cur.next;
            }
        }
        curLess.next = moreHead.next;
        return lessHead.next;
    }
}