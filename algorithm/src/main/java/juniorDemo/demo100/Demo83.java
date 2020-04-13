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
        ListNode pre = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
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
