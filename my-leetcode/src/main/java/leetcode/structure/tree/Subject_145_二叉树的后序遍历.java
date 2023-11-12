package leetcode.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_145_二叉树的后序遍历 {

    public static void main(String[] args) {


    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }


}




