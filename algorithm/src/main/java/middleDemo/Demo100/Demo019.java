package middleDemo.Demo100;

import org.junit.Test;
import utils.ListNode;
import utils.ListNodeDemo;

public class Demo019 {
    @Test
    public void test01(){
        ListNodeDemo ln = new ListNodeDemo();
        ListNode listNode = ln.listNode();
        ListNode listNode1 = removeNthFromEnd(listNode, 4);
        while (listNode1.next != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode left = pre;
        ListNode right = head;
        for (int i = 1; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return pre.next;
    }
}
