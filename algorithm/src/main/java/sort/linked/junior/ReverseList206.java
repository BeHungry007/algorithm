package sort.linked.junior;

import utils.ListNode;

/**
 *  反转单链表
 */
public class ReverseList206 {

    /**
     * 1. 需要反转的链表节点设为end；
     * 2. 使用tmp接受end.next;
     * 3. 将end.next指向链表的头结点pre.next;
     * 4. 链表的上一节点指向end节点pre.next = end;
     * 5. end节点指向下一个需要反转的节点tmp；
     * ps: head节点在结束的时候，需要将它的下一个节点置为null,否则会产生环形链表。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode end = head.next;
        while (end.next !=null) {
            ListNode tmp = end.next;
            end.next = pre.next;
            pre.next = end;
            end = tmp;
        }
        head.next = null;
        return pre.next;
    }
}
