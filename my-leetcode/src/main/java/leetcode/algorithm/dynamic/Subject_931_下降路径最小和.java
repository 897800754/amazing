package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）
 * 。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 **/
public class Subject_931_下降路径最小和 {

    public static void main(String[] args) {

        System.out.println(minFallingPathSum(
                new int[][]{
                        {2, 1, 3},
                        {6, 5, 4},
                        {7, 8, 9}
                }
        ));
    }

    /**
     * 使用滚动数组优化dp数组的控件
     *
     * @param matrix
     * @return
     */
    public static int minFallingPathSum(int[][] matrix) {
        //由于无后效性,只需要使用len*2的一维数组作为dp数组
        //遍历次数为偶数,元素放在[0,len-1],为奇数放在[len,2*len-1]
        int[] dp = new int[matrix.length * 2];
        //初始化dp数组
        for (int i = 0; i < matrix[0].length; i++) {
            dp[i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {

            int beforeDpIndex = i % 2 == 0 ? matrix.length : 0;

            int startDpIndex = i % 2 == 0 ? 0 : matrix.length;

            //最左侧
            dp[startDpIndex] = Math.min(dp[beforeDpIndex], dp[beforeDpIndex + 1]) + matrix[i][0];
            startDpIndex++;
            beforeDpIndex++;
            //中间
            for (int j = 1; j < matrix[i].length - 1; j++) {
                dp[startDpIndex] = Math.min(Math.min(dp[beforeDpIndex - 1], dp[beforeDpIndex]), dp[beforeDpIndex + 1]) + matrix[i][j];
                startDpIndex++;
                beforeDpIndex++;
            }
            //最右侧
            dp[startDpIndex] = Math.min(dp[beforeDpIndex - 1], dp[beforeDpIndex]) + matrix[i][matrix[i].length - 1];

            if (i == matrix.length - 1) {
                //最后一行了
                //遍历数组
                int min = Integer.MAX_VALUE;
                int limit = startDpIndex >= matrix.length ? matrix.length * 2 : matrix.length;

                for (int j = startDpIndex >= matrix.length ? matrix.length : 0; j < limit; j++) {
                    min = Math.min(dp[j], min);
                }
                return min;

            }
        }
        return matrix[0][0];
    }

}
