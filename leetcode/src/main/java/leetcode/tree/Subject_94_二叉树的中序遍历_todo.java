package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_94_二叉树的中序遍历_todo {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode treeNode = new TreeNode(10, left, right);
        List<Integer> integers = inorderTraversal0(treeNode);
        System.out.println(integers);
    }

    /**
     * 左,中,右
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode head = root;
        inorderTraversal(head, res);
        return res;
    }

    /**
     * 通过stack显示遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    /**
     * 递归中序遍历
     *
     * @param head
     * @param res
     * @return
     */
    private static void inorderTraversal(TreeNode head, List<Integer> res) {
        PriorityQueue<Object> objects = new PriorityQueue<>();
        if (head == null) {
            return;
        }
        inorderTraversal(head.left, res);
        res.add(head.val);
        inorderTraversal(head.right, res);
    }


}




