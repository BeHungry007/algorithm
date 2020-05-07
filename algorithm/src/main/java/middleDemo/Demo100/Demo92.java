package middleDemo.Demo100;

import org.junit.Test;
import utils.ListNode;

/**
 * 反转链表II
 * 反转从位置m到n的链表。请使用一趟完成反转。
 */
public class Demo92 {
    @Test
    public void test01(){

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode pre1 = pre;
        for (int i = 1; i < m; i++) {
            pre1 = pre1.next;
        }
        ListNode ln = pre1.next;
        for (int i = m; i < n; i++) {
            ListNode next = ln.next;
            ln.next = next.next;
            next.next = pre1.next;
            pre1.next = next;
        }
        return pre.next;
    }
}
