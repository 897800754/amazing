package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/house-robber/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_198_打家劫舍 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    /**
     * (1)子问题枚举
     * 求偷1个房间最优解
     * 求偷2个房间最优解
     * 求偷3个房间最优解
     * (2)定义状态
     * dp[i]
     * i:房间
     * (3)状态方程
     * dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
     * <p>
     * (4)初始化dp
     * dp[0]= nums[0];
     * dp[1]= Maths.max(nums[0],nums[1]);
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


    /**
     * 错误解
     *
     * @param nums
     * @return
     */
    public static int rob0(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int s = 0;
        int f = 1;
        int sMax = 0;
        int fMax = 0;
        while (s <= nums.length - 1 || f <= nums.length - 1) {
            if (f <= nums.length - 1) {
                fMax = fMax + nums[f];
                f += 2;
            }
            if (s <= nums.length - 1) {
                sMax = sMax + nums[s];
                s += 2;
            }

        }
        return Math.max(sMax, fMax);
    }
}
