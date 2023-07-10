package leetcode.structure.tree;

/**
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
        TreeNode treeNode = insertIntoMaxTree(parent, 5);
        System.out.println(treeNode);

    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //将节点插入到指定的位置.
        insert(root, root, val);
        return root;
    }

    private static TreeNode insert(TreeNode parent, TreeNode current, int val) {
        int val1 = current.val;

        if (val1 > val) {
            if (current.left == null) {
                current.left = new TreeNode(val);
                return current.left;
            }
            TreeNode insert = insert(current, current.left, val);
            balance(parent, current.left, insert);
            return current.left;
        }
        if (val1 < val) {
            if (current.right == null) {
                current.right = new TreeNode(val);
                return current.right;
            }
            TreeNode insert = insert(current, current.right, val);
            balance(parent, current.right, insert);
            return current.right;
        }
        return null;

    }


    private static void balance(TreeNode parentParent, TreeNode parent, TreeNode insertTree) {
        //如果插入节点的值大于其父节点,那么进行位置替换
        if (parent.val < insertTree.val) {
            TreeNode temp = parent;
            TreeNode leftTemp = parent.left;
            TreeNode rightTemp = parent.right;
            TreeNode left = insertTree.left;
            TreeNode right = insertTree.right;
            parent = insertTree;
            parent.left = leftTemp;
            parent.right = temp;
            temp.left = left;
            temp.right = right;
            parentParent.right = parent;

        }

    }


}




