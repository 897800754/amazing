package leetcode.structure.tree;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) = Math(f(x.left),f(x.right))
 **/
public class Subject_104_二叉树的最大深度 {
    public static void main(String[] args) {

    }

    public int maxDepth1(TreeNode root) {
        return maxDepth(root, 0);
    }

    /**
     * 我的解
     *
     * @param node
     * @param i
     * @return
     */
    private Integer maxDepth(TreeNode node, int i) {
        if (node == null) {
            return i;
        } else {
            i = i + 1;
            return Math.max(maxDepth(node.left, i), maxDepth(node.right, i));
        }
    }

    /**
     * 官方推荐解
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }


}
