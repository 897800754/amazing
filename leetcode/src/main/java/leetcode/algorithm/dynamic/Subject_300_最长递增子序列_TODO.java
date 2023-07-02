package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_300_最长递增子序列_TODO {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{
                1, 3, 6, 7, 9, 4, 10, 5, 6
        }));
    }

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * <p>
     * 枚举子问题
     * (0)求解以10为结尾的子序列长度 1
     * (1)求解以9为结尾的子序列长度 1
     * (2)求解以2为结尾的子序列长度 1
     * (3)求解以5为结尾的子序列长度 2
     * <p>
     * (4)求解以3为结尾的子序列长度 2
     * (5)求解以7为结尾的子序列长度 3
     * <p>
     * (6)求解以101为结尾的子序列长度 4
     * (7)求解以18为结尾的子序列长度 4
     * <p>
     * 定义状态
     * dp[x] x位第N个元素, dp[x]为以第N个元素结尾 最大子序列长度
     * <p>
     * 状态转移方程
     * <p>
     * <p>
     * <p>
     * when table[x]>Max(table[0:x-1]=>n)  then dp[x] = dp[n]+1
     * when table[x]<=Max(table[0:x-1]=>n) then dp[x] = dp[n]
     * <p>
     * dp初始化
     * dp[0] =1
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int mMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            mMax = Math.max(max, mMax);
        }
        return mMax;
    }


}
