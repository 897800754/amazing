package leetcode.structure.tree;

/**
 * TODO 题目看不懂
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_998_最大二叉树II_TODO {

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(4);

        TreeNode left = new TreeNode(1);
        parent.left = left;

        TreeNode right = new TreeNode(3);

        TreeNode rightLeft = new TreeNode(2);
        right.left = rightLeft;

        parent.right = right;

//        TreeNode treeNode = insertIntoMaxTree(parent, 5);
//        System.out.println(treeNode);

    }

//    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
//        if (root == null) {
//            return null;
//        }
//
//        TreeNode dmTreeNode = new TreeNode();
//        dmTreeNode.left = root;
//        insertIntoMaxTree(dmTreeNode, root, val, true);
//        return dmTreeNode.left;
//    }

    /**
     * @param compareNodeParent
     * @param compareNode
     * @param val
     * @param flag              true->左,false->右
     * @return
     */
//    public static void insertIntoMaxTree(TreeNode compareNodeParent, TreeNode compareNode, int val, boolean flag) {
//        if (compareNode == null) {
//            compareNode = new TreeNode(val);
//        }
//        //比较值
//        int compareValue = compareNode.val;
//
//        if (compareValue > val) {
//            //继续向下找
//            insertIntoMaxTree(compareNode, compareNode.left, val, true);
////            insertIntoMaxTree(compareNode, compareNode.left, val);
//        } else {
//            //进行替换
//            if (flag) {
//                //替换parent的左子节点
//                compareNodeParent.left = new TreeNode(val);
//                compareNodeParent.left.left = compareNode;
//            } else {
//                compareNodeParent.right = new TreeNode(val);
//                compareNodeParent.right.right = compareNode;
//            }
//        }
//    }


}




