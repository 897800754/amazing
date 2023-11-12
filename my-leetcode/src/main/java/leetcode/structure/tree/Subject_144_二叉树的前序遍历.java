package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_144_二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode treeNode = new TreeNode(10, left, right);
        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    /**
     * dfs深度优先遍历
     *
     * @param root
     * @param res
     */
    private static void preorderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }

}




