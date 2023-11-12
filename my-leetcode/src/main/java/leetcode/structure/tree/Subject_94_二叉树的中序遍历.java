package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_94_二叉树的中序遍历 {

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
     * 通过stack 先进后出,模拟线程栈
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal0(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (temp != null || !stack.empty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                //左节点为空,弹出当前节点.
                TreeNode pop = stack.pop();
                res.add(pop.val);
                temp = pop.right;
            }
        }
        return res;
    }

    /**
     * 递归中序遍历
     * dfs(深度优先)算法
     *
     * @param head
     * @param res
     * @return
     */
    private static void inorderTraversal(TreeNode head, List<Integer> res) {
        if (head == null) {
            return;
        }
        inorderTraversal(head.left, res);
        res.add(head.val);
        inorderTraversal(head.right, res);
    }


}




