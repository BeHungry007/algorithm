package sort.linked.junior;

import utils.ListNode;

public class ReverseList206 {

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
