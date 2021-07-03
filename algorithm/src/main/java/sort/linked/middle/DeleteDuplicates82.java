package sort.linked.middle;

import utils.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 */
public class DeleteDuplicates82 {

    /**
     * 题解：
     *      1. 新建一个链表dummy，其next指向head；此时新建一个链表指向cur；
     *      2. 对cur进行操作，想判定数字是否重复，需要确定cur.next和cur.next.next不为null。
     *      3. 当不为null的时候，判定两者的value是否相等？
     *                           如果相等，记录下来x，while循环删除cur.next，一直找到cur.next.value ！= x || cur.next != null,
     *                           如果不相等，cur = cur.next;
     *      4. return dummy.next;
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

}
