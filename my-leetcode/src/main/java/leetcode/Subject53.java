package leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author: cg
 * @date: 2023-02-05 23:14
 **/
public class Subject53 {

    public int maxSubArray(int[] nums) {
        int max = 0;
        //至少一个
        for (int i = nums.length; i >= 1; i--) {
            int[][] subArr = getSubArr(i, nums);
            for (int i1 = 0; i1 < subArr.length; i1++) {
                int i1Sum = 0;
                for (int i2 = 0; i2 < subArr[i1].length; i2++) {
                    i1Sum += subArr[i1][i2];
                }
                if (max < i1Sum) {
                    max = i1Sum;
                }
            }

        }

        return max;
    }

    /**
     * @param i    子数组长度  2
     * @param nums 原始数组 nums = [1,2,3]
     * @return [[1, 2], [2, 3]]
     */
    private static int[][] getSubArr(int i, int[] nums) {
        //1 --> length
        //2 -->>2 1 / 3 2 / 4 3 / ->>>length -1 ,  nums.length >=2
        //3 --->>3 1/ 4 2
        //推断出结果长度
        int[][] res = new int[nums.length - 1][i];

        int beginIndex = 0;

        for (int j = 0; j < nums.length - 1; j++) {

            int endIndex = beginIndex + i - 1;

            int[] subArr = new int[i];

            int temp = 0;

            for (int i1 = beginIndex; i1 <= endIndex; i1++) {
                subArr[temp] = nums[i1];
                temp++;
            }

            beginIndex++;
            res[j] = subArr;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] subArr = getSubArr(3, new int[]{1, 2, 3, 4});
        for (int[] ints : subArr) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
