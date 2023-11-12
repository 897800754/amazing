package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/unique-paths-ii/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_63_不同路径II {

    public static void main(String[] args) {

    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     * dp[m][n] = dp[m][n-1]+dp[m-1][n] 当 m,n-1为障碍物时,为0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || flag) {
                dp[i][0] = 0;
                flag = true;
            } else {
                dp[i][0] = 1;
            }
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || flag) {
                dp[0][i] = 0;
                flag = true;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
