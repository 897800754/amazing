package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_230_二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode treeNode = new TreeNode(10, left, right);
        System.out.println(kthSmallest(treeNode, 3));
    }

    /**
     * 递归中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> integers = new ArrayList<>();
        kthSmallest0(root, k, integers);
        return integers.get(integers.size() - 1);
    }

    public static void kthSmallest0(TreeNode root, int k, List<Integer> res) {
        if (root == null) {
            return;
        }
        kthSmallest0(root.left, k, res);
        if (res.size() == k) {
            //返回
            return;
        }
        res.add(root.val);
        kthSmallest0(root.right, k, res);
    }
}




