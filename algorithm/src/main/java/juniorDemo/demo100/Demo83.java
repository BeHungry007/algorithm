package juniorDemo.demo100;

import org.junit.Test;

import java.util.HashSet;

//删除排序链表中的重复元素
public class Demo83 {
    @Test
    public void test01(){

    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Integer num = head.val;
        ListNode pre = head;
        while (head.next != null) {
            if (num == head.next.val) {
                head.next = head.next.next;
            } else {
                num = head.next.val;
                head = head.next;
            }
        }
        return pre;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
