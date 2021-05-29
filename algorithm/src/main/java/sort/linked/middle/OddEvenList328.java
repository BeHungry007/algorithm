package sort.linked.middle;

import utils.ListNode;

/**
 * 奇偶链表
 */
public class OddEvenList328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        if (head == null || head.next == null) return head;
        ListNode right = head.next;


        ListNode odd = head;  // odd指向奇节点的末尾
        ListNode even = head.next; // even指向偶节点的末尾
        while (even != null && even.next != null){  // 偶数节点之后还有节点没有

            // 1 > 2 > 4 > 3 > 5   odd = 2, even = 4
            // t = 4;
            ListNode t = odd.next;  // 临时保存偶节点的开头
            // 2 > 3
            odd.next = even.next;   // 奇节点末尾连接【偶节点】第一个节点
            // 4 > 5;
            even.next = even.next.next;    // 偶节点末尾连接【偶节点】第二个节点
            // 3 > 4;
            odd.next.next = t;  // 奇数节点--->偶数节点的开头


            odd = odd.next;
            even = even.next;
        }

        return head;
    }
}
