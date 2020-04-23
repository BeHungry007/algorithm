package utils;

public class ListNodeDemo {
    public ListNode listNode;
    public ListNode listNode() {
        ListNode pre1 = new ListNode(1);
        ListNode pre2 = new ListNode(2);
        ListNode pre3 = new ListNode(3);
        ListNode pre4 = new ListNode(4);
        ListNode pre5 = new ListNode(5);
        ListNode pre6 = new ListNode(6);
        pre1.next = pre2;
        pre2.next = pre3;
        pre3.next = pre4;
        pre4.next = pre5;
        pre5.next = pre6;
        return pre1;
    }

    public ListNode listDouble() {
        ListNode pre1 = new ListNode(1);
        ListNode pre2 = new ListNode(2);
        ListNode pre3 = new ListNode(3);
        ListNode pre4 = new ListNode(4);
        ListNode pre5 = new ListNode(5);
        ListNode pre6 = new ListNode(6);
        pre1.next = pre2;
        pre2.next = pre3;
        pre3.next = pre4;
        pre4.next = pre5;
        pre5.next = pre6;
        pre2.pre = pre1;
        pre3.pre = pre2;
        pre4.pre = pre3;
        pre5.pre = pre4;
        pre6.pre = pre5;
        return pre1;
    }
}
