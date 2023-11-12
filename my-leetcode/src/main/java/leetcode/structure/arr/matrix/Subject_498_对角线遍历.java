package leetcode.structure.arr.matrix;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/diagonal-traverse/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_498_对角线遍历 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        })));
    }

    /**
     * 思路:对角线,以及函数,边界
     * <p>
     * 对角线数量: m+n-1
     *
     * @param mat
     * @return
     */
    public static int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int total = m * n;
        int[] ans = new int[total];
        int cursor = 0;

        for (int i = 0; i < m + n - 1; i++) {
            //对角线公式
            if (i % 2 == 1) {
                //自上而下


            } else {
                //自下而上

            }
        }
        return ans;
    }

}




