package leetcode.structure.tree;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_654_最大二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);

    }

    private static TreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        //找到最大值所在索引
        TreeNode left = null;
        if (maxIndex - 1 >= start) {
            left = build(nums, start, maxIndex - 1);
        }
        TreeNode right = null;
        if (maxIndex + 1 <= end) {
            right = build(nums, maxIndex + 1, end);
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = nums[maxIndex];
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }
}




