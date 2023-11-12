package leetcode.structure.tree;

/**
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_Offer33_二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3

        }));

    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * ([左子树],[右子树],[ROOT])
     * 二叉搜索树性质
     * 若它的左子树不为空，则左子树上所有节点的值都小于根节点的值
     * 若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
     * 它的左右子树也分别为二叉搜索树
     * 左小右大,root居中
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0 || postorder.length == 1) {
            return true;
        }
        //至少两个元素,对树进行拆分
        //[2,3,5]
        //
        return verifyPostorder(postorder, -1, postorder.length - 1);
    }

    //r=2
    private static boolean verifyPostorder(int[] postorder, int l, int r) {

        if (l >= r || r <= 0) {
            //只有一个元素或者无元素
            return true;
        }
        //5
        int rootVal = postorder[r];
        //枚举拆分左右子树的所有情况
        //-1<=1
        while (l <= r - 1) {
            if (l == -1) {
                //只有右子树
                //取出最右边节点
                if (rootVal > postorder[r - 1]) {
                    l++;
                    //不成立
                    continue;
                } else {
                    if (verifyPostorder(postorder, -1, r - 1)) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
            if (l == r - 1) {
                //只有左子树
                if (rootVal < postorder[r - 1]) {
                    l++;
                    //不成立
                    continue;
                } else {
                    if (verifyPostorder(postorder, -1, r - 1)) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
            //既有左子树又有右子树
            if (rootVal > postorder[l] && rootVal < postorder[r - 1] && verifyPostorder(postorder, 0, l) && verifyPostorder(postorder, l + 1, r - 1)) {
                return true;
            }
            //不成立
            l++;
        }
        return false;
    }
}




