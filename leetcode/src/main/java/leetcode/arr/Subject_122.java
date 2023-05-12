package leetcode.arr;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_122 {

    public static void main(String[] args) {
        int[] req = new int[]{7, 1, 5, 3, 6, 4};
        int i = maxProfit1(req);
        System.out.println(i);
    }

    /**
     * 动态规划
     * * 状态方程
     * * <p>
     * * dp[i][0]表示没有股票的最高利润
     * * dp[i][1]表示有股票的最大利润
     * * <p>
     * * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i])
     * * <p>
     * * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i])
     * * <p>
     * * 确认边界
     * * dp[0][0] = 0;
     * * dp[0][1] = -price[0];
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 动态规划
     * 优化版,记录每一天的最优解,
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        int n = prices.length;

        int dp0 = 0;
        int dp1 = -prices[0];

        for (int i = 1; i < n; i++) {
            int max0 = Math.max(dp0, dp1 + prices[i]);
            int max1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = max0;
            dp1 = max1;
        }
        return Math.max(dp0, dp1);
    }


    public static int maxProfit3(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfit = maxProfit + prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }


}
