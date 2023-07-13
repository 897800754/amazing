package leetcode.structure.tree;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_106_从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);

    }

    /**
     * @param inorder   中序遍历 [[左子树],root,[右子树]]
     * @param postorder 后序遍历 [[左子树],[右子树],root]
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1, map);

    }

    /**
     * [1,2,3]
     * [1,3,2]
     */
    private static TreeNode buildTree(int[] inorder, int[] postorder, int il, int ir, int pl, int pr, HashMap<Integer, Integer> map) {
        if (il > ir || pl > pr) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        //中序遍历 root index
        //1
        Integer inRootIndex = map.get(postorder[pr]);

        treeNode.val = postorder[pr];
        //右子树长度
        // 1 = 2-1
        int len = ir - inRootIndex;
        //2,2,1,1
        treeNode.right = buildTree(inorder, postorder, inRootIndex + 1, inRootIndex + len, pr - len, pr - 1, map);
        //0,0,0,0
        treeNode.left = buildTree(inorder, postorder, il, inRootIndex - 1, pl, pr - 1 - len, map);

        return treeNode;
    }


}




