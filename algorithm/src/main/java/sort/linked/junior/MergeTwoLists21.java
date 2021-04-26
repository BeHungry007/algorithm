package sort.linked.junior;

import utils.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();

        ListNode ans = new ListNode();
        pre.next = ans;
        while (l1 != null && l2 != null) {
            int i = l1.val;
            int j = l2.val;
            if (i >= j) {
                ans.val = j;
                l2 = l2.next;
            } else {
                ans.val = i;
                l1 = l1.next;
            }
            ans.next = new ListNode();
            ans = ans.next;
        }
        if (l1 == null) {
            ans.val = l2.val;
            ans.next = l2.next;
        } else if (l2 == null) {
            ans.val = l1.val;
            ans.next = l1.next;
        }
        return pre.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode ans = new ListNode();
        pre.next = ans;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        while (l1 != null && l2 != null) {
            int m = l1.val;
            int n = l2.val;
            if ( m >= n) {
                ans.next = l2;
                ans = ans.next;
                l2 = l2.next;
            } else {
                ans.next = l1;
                ans = ans.next;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            ans.next = l2;
        } else if (l2 == null) {
            ans.next = l1;
        }
        return pre.next.next;


    }
}
