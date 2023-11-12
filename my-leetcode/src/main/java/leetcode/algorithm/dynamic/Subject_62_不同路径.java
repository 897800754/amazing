package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/unique-paths/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_62_不同路径 {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(uniquePaths0(51, 9));
    }

    /**
     * 1.枚举子问题
     * 到[1,1]的路径 1
     * 到[1,2]的路径 1
     * 到[2,1]的路径 1
     * 到[2,2]的路径 2 [1,2](1)+[2,1](1) = 2
     * 到[1,3]的路径 1
     * 到[2,3]的路径 3 [2,2](2)+[1,3](1) = 3
     * <p>
     * 2.定义子问题
     * dp[x][y] 到达x,y的路径数量, x>0 ,y>0
     * <p>
     * <p>
     * 3.状态转移方程
     * dp[m][n] = dp[m-1][n]+dp[m][n-1],m-1>0,n-1>0
     * 4.dp数组数据初始化
     * dp[0][0] = 1
     * <p>
     * 5.遍历
     * 使用递归
     *
     * <p>
     * 6.是否可以优化,例如使用滑动窗口
     * 发现问题:使用递归,导致了计算超时,使用ji
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths0(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePaths(m, n, dp);
    }

    public static int uniquePaths(int m, int n, int[][] cache) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (cache[m - 1][n - 1] != 0) {
            return cache[m - 1][n - 1];
        }


        int i = uniquePaths(m - 1, n, cache);
        int i1 = uniquePaths(m, n - 1, cache);

        cache[m - 1][n - 1] = i + i1;
        return i + i1;
    }


}
