package leetcode.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_116_填充每个节点的下一个右侧节点指针 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            for (int i = 1; i < size; i++) {
                Node next = queue.poll();
                poll.next = next;
                poll = next;
                if (next.left != null) {
                    queue.offer(next.left);
                }
                if (next.right != null) {
                    queue.offer(next.right);
                }
            }
        }
        return root;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}




