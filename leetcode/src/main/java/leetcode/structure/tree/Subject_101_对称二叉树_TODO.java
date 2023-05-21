package leetcode.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_101_对称二叉树_TODO {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(8);
        TreeNode treeNode = new TreeNode(10, left, right);
        System.out.println(isSymmetric(treeNode));
    }

    /**
     * bfs-广度优先遍历,使用队列,fifo
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queueLeft = new LinkedList<>();
        TreeNode left = root.left;
        TreeNode right = root.right;
        queueLeft.add(left);
        queueLeft.add(right);
        //队列为空,跳出循环
        while (!queueLeft.isEmpty()) {
            TreeNode remove = queueLeft.remove();
            TreeNode remove1 = queueLeft.remove();
            if (remove == null && remove1 == null) {
                continue;
            }
            if (remove == null || remove1 == null) {
                return false;
            }
            if (remove.val != remove1.val) {
                return false;
            }
            queueLeft.add(remove.left);
            queueLeft.add(remove1.right);

            queueLeft.add(remove.right);
            queueLeft.add(remove1.left);
        }
        return true;
    }

}
