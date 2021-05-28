package sort.linked.middle;

import org.junit.Test;
import utils.ListNode;

//两数相加

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class AddTwoNumbers2 {
    @Test
    public void test01(){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode listNode = addTwoNumbers(l2, l1);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode pr = new ListNode(0);
        ListNode curr = pr;
        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        int temp = 0;
        while (l1.next != null && l2.next != null) {
            temp = temp + l1.val + l2.val;
            curr.next = new ListNode(temp % 10);
            curr = curr.next;
            temp = temp / 10;
            l1 = l1.next;
            l2 = l2.next;

        }
        if (l2.next != null) {
            l1.next = l2.next;
        }

        while (l1 != null ) {
            if (l2 != null) {
                temp = temp + l1.val + l2.val;
                l2 = null;
            } else {
                temp = temp + l1.val;
            }
            curr.next = new ListNode(temp % 10);
            temp = temp / 10;
            curr = curr.next;
            if (temp == 0) {
                break;
            }
            l1 = l1.next;
        }
        if (temp != 0) {
            curr = new ListNode(1);
        }
        return pr.next;
    }

}
