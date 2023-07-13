package leetcode.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/subtree-of-another-tree/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_572_另一棵树的子树 {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            if (isSame(poll, subRoot)) {
                return true;
            }
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return false;
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
