package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_98_验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        TreeNode treeNode = new TreeNode(10, left, right);
        System.out.println(isValidBST0(treeNode));
    }

    /**
     * 非递归解法,中序遍历->产生的数组 应该是 个升序的数组
     *
     * @param root
     * @return
     */
    public static boolean isValidBST0(TreeNode root) {
        //中节点>左节点,中节点<右节点
        ArrayList<Integer> res = new ArrayList<>();
        //迭代法
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()) {
            //迭代
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                TreeNode pop = stack.pop();
                if (!res.isEmpty()) {
                    if (res.get(res.size() - 1) >= pop.val) {
                        return false;
                    }
                }
                res.add(pop.val);
                temp = pop.right;
            }
        }
        return true;
    }


    /**
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * @param root
     * @param low
     * @param height
     * @return
     */
    public static boolean isValidBST(TreeNode root, Long low, Long height) {
        if (root == null) {
            return true;
        }
        //观察节点的值,需要在合理的区间内
        if (root.val <= low || root.val >= height) {
            return false;
        }
        return isValidBST(root.left, low, (long) root.val) && isValidBST(root.right, (long) root.val, height);
    }

}
