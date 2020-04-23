package middleDemo.Demo100;

import org.junit.Test;
import utils.ListNodeDemo;
import utils.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数
 * */
public class Demo61 {

    @Test
    public void test01(){
        ListNodeDemo listNodeDemo = new ListNodeDemo();
        utils.ListNode listNode = listNodeDemo.listNode();
        rotateRight(listNode, 2);

    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode pre = new ListNode(-1);

        pre.next = head;
        ListNode pre1 = pre;
        ListNode ln = pre;
        int tmp = 1;
        while(head.next != null) {
            tmp++;
            head = head.next;
        }
        k = k % tmp;
        int sum = 0;
        while (ln.next != null && sum < tmp - k) {
            sum++;
            ln = ln.next;
        }
        ListNode ln2 = pre.next;
        pre.next = ln.next;
        ln.next = null;

        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = ln2;
        return pre1.next;
    }
}
