package leetcode.algorithm.dynamic;


/**
 * 类名称: Subject_1289_下降路径最小和II
 * 创建人: chengang
 * 创建时间: 2023-07-07 18:11:33
 * 描述:
 * 类名称: Subject_1289_下降路径最小和II
 * 创建人: chengang
 * 创建时间: 2023-07-07 18:05:56
 * 描述: The minimum sum of descent paths ii for subject 1289
 * 父类:
 * 版本: 1.0.0
 * <p>
 * 父类: @see Runnable
 * 版本: 1.0.0
 */
public class Subject_1289_下降路径最小和II {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2}}));

    }

    /**
     * <p>
     * dp[i][j] = grid[i][j]+Min(dp[i-1,0->len(n!=j)])
     * 时间复杂度 n的三次方
     * 优化---> @see leetcode.algorithm.dynamic.Subject_1289_下降路径最小和II#minFallingPathSum0(int[][])
     *
     * @param grid
     * @return
     */
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }

        int[][] dp = new int[n][n];
        //初始化dp
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i];
        }
        //递推dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int min = Integer.MAX_VALUE;

                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(dp[i - 1][k], min);
                    }
                }
                dp[i][j] = grid[i][j] + min;

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[n - 1].length; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }



}
