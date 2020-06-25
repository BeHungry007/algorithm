package middleDemo.Demo100;

import java.util.Hashtable;

public class Demo146 {
    class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }
        private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

    }


}

