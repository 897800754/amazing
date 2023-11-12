package leetcode.structure.tree;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {


    }

    /**
     * 前序遍历 [根节点,[左子树前序遍历],[右子树前序遍历]]
     * 中序遍历 [[左子树前序遍历],根节点,[右子树前序遍历]]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, length - 1, 0, length - 1, map);
    }

    /**
     * 测试用例
     * [1,2,3]
     * [2,1,3]
     */
    private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir, HashMap<Integer, Integer> map) {
        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        //初始化根节点值
        treeNode.val = preorder[pl];
        //获取中序遍历数组根节点的下标
        //中序数组根节点下标-中序数组最左下标 = 左子树数组长度
        //左子树数组长度
        //k =1
        int k = map.get(preorder[pl]) - il;

        //参数3:左子树前序数组
        //1,1,0,0
        treeNode.left = buildTree(preorder, inorder, pl + 1, pl + k, il, il + k - 1, map);
        //2,2,2,2
        treeNode.right = buildTree(preorder, inorder, pl + 1 + k, pr, il + 1 + k, ir, map);
        return treeNode;
    }


}




