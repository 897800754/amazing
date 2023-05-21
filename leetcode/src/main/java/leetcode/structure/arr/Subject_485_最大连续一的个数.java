package leetcode.structure.arr;

/**
 * https://leetcode.cn/problems/max-consecutive-ones/
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 示例 2:
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_485_最大连续一的个数 {

    public static void main(String[] args) {
        int[] ints = {1, 1, 0, 1, 1, 1};
//        int[] ints = {1};

        int maxConsecutiveOnes = findMaxConsecutiveOnes1(ints);
        System.out.println(maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes1(int[] nums) {

        int subMax = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                subMax++;
            } else {
                max = Math.max(subMax, max);
                subMax = 0;
            }
        }
        return Math.max(subMax, max);
    }
}




