package leetcode.algorithm.dynamic;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 * f(x) =
 **/
public class Subject_53_最大子数组和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray0(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     * [-2,1,-3,4,-1,2,1,-5,4]
     * <p>
     * (1)枚举子问题
     * 经过-2的最大连续子序列
     * 经过1的最大连续子序列
     * 经过-3的最大连续子序列
     * ....
     * 子问题转换
     * 以-2结尾的最大子序列之和
     * 以1结尾的最大子序列之和
     * 以-3结尾的最大子序列之和
     * <p>
     * <p>
     * (2)定义状态(定义子问题)
     * dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和。
     * (3)状态转移方程
     * <p>
     * if(dp[i-1]>0) dp[i] = dp[i-1]+num[i]
     * 或者
     * if(num[i-1]<0) dp[i] = num[i]
     * (4)dp数组(状态)初始化
     * dp[0]根据定义，只有 1 个数，一定以 nums[0] 结尾，因此 dp[0] = nums[0]。
     * (5)进一步思考是否有优化空间
     * 例如滚动变量法,代替状态数组,例如70题爬梯子问题
     * <p>
     * 什么是无后效性?
     * <p>
     * 为了保证计算子问题能够按照顺序、不重复地进行，动态规划要求已经求解的子问题不受后续阶段的影响。
     * 这个条件也被叫做「无后效性」。换言之，动态规划对状态空间的遍历构成一张有向无环图，遍历就是该有向无环图的一个拓扑序。
     * 有向无环图中的节点对应问题中的「状态」，图中的边则对应状态之间的「转移」，转移的选取就是动态规划中的「决策」。
     * <p>
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        //定义dp数组
        int[] dp = new int[nums.length];
        //初始化dp数组
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 优化版本
     * 使用滚动变量代替dp数组
     *
     * @param nums
     * @return
     */
    public static int maxSubArray0(int[] nums) {
        //使用变量记录最大值
        int max = nums[0];
        //记录上个状态最大值
        int pre = 0;

        for (int i = 1; i < nums.length; i++) {
            //计算出当前状态最大值
            pre = Math.max(pre + nums[i], nums[i]);

            max = Math.max(max, pre);
        }
        return max;
    }
}
