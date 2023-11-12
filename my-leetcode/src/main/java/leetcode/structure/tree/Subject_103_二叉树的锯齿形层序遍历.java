package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_103_二叉树的锯齿形层序遍历 {

    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(5);
        TreeNode left = new TreeNode(2, leftLeft, rightRight);
        TreeNode right = new TreeNode(3);

        TreeNode treeNode = new TreeNode(1, left, right);
        System.out.println(zigzagLevelOrder(treeNode));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        //双端队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //为true , fifo 先左后右
        boolean flag = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> subRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    TreeNode treeNode = queue.pollFirst();
                    subRes.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                } else {
                    TreeNode treeNode = queue.pollLast();
                    subRes.add(treeNode.val);
                    if (treeNode.right != null) {
                        queue.offerFirst(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        queue.offerFirst(treeNode.left);
                    }
                }
            }
            flag = !flag;
            res.add(subRes);
        }
        return res;
    }

}




