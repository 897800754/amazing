package leetcode.algorithm.dynamic;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_322_零钱兑换_TODO {

    public static void main(String[] args) {
    }

    /**
     * 枚举子问题
     * 求解总金额为1的硬币个数
     * 求解总金额为2的硬币个数
     * <p>
     * 定义状态
     * dp[x],x为总金额,dp[x]为总金额为x时硬币个数
     * <p>
     * 状态转移方程
     * dp[x] = dp[x-1] 可以凑整且当硬币可以被替换
     * dp[x] = do[x-1]+1 可以凑整且当硬币不可以被替换
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        //降序排序
        Arrays.sort(coins);
        int[] dp = new int[amount];

        for (int i = 0; i < amount; i++) {


        }
        return dp[amount - 1];
    }
}
