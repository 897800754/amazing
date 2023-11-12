package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * 1.枚举子问题
     * 求解第一天的买入/卖出利润最大化
     * 求解第二填的买入/卖出利润最大化
     * 2.定义状态
     * dp[i][j]
     * i:天数
     * j:买入(0)/卖出(1)
     * 3.定义状态转移方程
     * 分情况讨论
     * 当天买入
     * dp[i][0] = max(dp[i-1][1]-price[i],-price[i])
     * <p>
     * 当天卖出
     * dp[i][1] = max(dp[i-1][0]+price[i],dp[i-1][1])
     *
     * <p>
     * 4.初始化状态数组
     * dp[0][0] = -price[0]
     * dp[0][1] = 0
     * 5.思考优化,是否可以使用
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[dp.length - 1][1];
    }

}
