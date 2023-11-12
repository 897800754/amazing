package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_257_二叉树的所有路径 {

    public static void main(String[] args) {
        TreeNode leftLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(5);
        TreeNode left = new TreeNode(2, leftLeft, rightRight);
//        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode treeNode = new TreeNode(1, left, right);
        System.out.println(binaryTreePaths(treeNode));
    }

    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrack(res, root, new LinkedList<TreeNode>() {
            {
                add(root);
            }
        });
        return res;
    }

    /**
     * 回溯
     *
     * @param res
     * @param root
     * @param list
     */
    private static void backtrack(List<String> res, TreeNode root, List<TreeNode> list) {
        if (root.left == null && root.right == null) {
            //终止条件
            res.add(list.stream().map(x -> String.valueOf(x.val)).collect(Collectors.joining("->")));
        } else {
            if (root.left != null) {
                list.add(root.left);
                backtrack(res, root.left, list);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                list.add(root.right);
                backtrack(res, root.right, list);
                list.remove(list.size() - 1);
            }
        }
    }

}




