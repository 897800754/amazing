package leetcode.structure.tree;

import java.util.*;

/**
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_102_二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(5);
        TreeNode left = new TreeNode(2, leftLeft, rightRight);
        TreeNode right = new TreeNode(3);

        TreeNode treeNode = new TreeNode(1, left, right);
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> objects = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode poll = queue.poll();
                //获取节点
                objects.add(poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            res.add(objects);

        }
        return res;
    }

}
