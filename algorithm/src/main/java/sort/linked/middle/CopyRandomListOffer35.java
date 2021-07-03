package sort.linked.middle;

import utils.Node;

/**
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class CopyRandomListOffer35 {

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        copyNext(head);
        copyRandom(head);
        return link(head);
    }
    private void copyNext(Node head){
        while(head != null){
            Node copyNode = new Node(head.val);
            Node nextNode = head.next;
            copyNode.next = nextNode;
            head.next = copyNode;

            head = nextNode;
        }
    }

    private void copyRandom(Node node){
        while(node != null){
            Node copyNode = node.next;
            if(node.random != null){
                Node rnode = node.random;
                //
                copyNode.random = rnode.next;
            }
            node = copyNode.next;
        }
    }

    private Node link(Node head){
        Node copyNode = head.next;
        Node copyHead = copyNode;
        head.next = copyNode.next;
        head = head.next;

        while(head != null){
            //将连接断开
            copyNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            copyNode = copyNode.next;
        }
        return copyHead;
    }
}
