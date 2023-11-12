package leetcode.structure.arr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum/description/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_1 {

    public static void main(String[] args) {
        int[] req1 = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(req1, target)));
    }

    /**
     * 也可以使用hash表记录差值,
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int t = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == t) {
                    //找到了.
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }
}




