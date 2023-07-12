package leetcode.structure.tree;

import leetcode.structure.link.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/linked-list-in-binary-tree/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_1367_二叉树中的链表 {
    public static void main(String[] args) {

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        //找到TreeNode当中 与root节点值相同的treeNode
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            if (isSamePath(poll, head)) {
                return true;
            }

            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return false;
    }

    private boolean isSamePath(TreeNode root, ListNode head) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return root.val == head.val && (isSamePath(root.right, head.next) || isSamePath(root.left, head.next));

    }
}
