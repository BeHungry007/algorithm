package ImportantDemo;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Demo876Junior {

    public ListNode middleNode(ListNode head) {
        ListNode[] ln = new ListNode[100];
        int i = 0;
        while (head != null) {
            ln[i++] = head;
            head = head.next;
        }
        return ln[i/2];
    }
}
