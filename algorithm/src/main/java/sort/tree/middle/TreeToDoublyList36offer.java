package sort.tree.middle;

import utils.Node;

public class TreeToDoublyList36offer {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}
