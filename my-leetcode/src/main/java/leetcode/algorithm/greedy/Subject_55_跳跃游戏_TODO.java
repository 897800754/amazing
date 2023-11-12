package leetcode.algorithm.greedy;

/**
 * https://leetcode.cn/problems/jump-game/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 * <p>
 **/
public class Subject_55_跳跃游戏_TODO {
    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));

//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));

    }

    /**
     * 贪心算法
     * <p>
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        int endIndex = nums[0];
        for (int i = 0; i <= endIndex; i++) {
            maxIndex = Math.max(nums[i] + i, maxIndex);

            endIndex = maxIndex;
            if (endIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
