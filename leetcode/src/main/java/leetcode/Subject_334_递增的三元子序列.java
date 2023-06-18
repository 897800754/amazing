package leetcode.structure.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_15_三数之和_TODO {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{0, 3, 0, 1, 1, -1, -5, -5, 3, -3, -3, 0}));
    }

    /**
     * 难点:如果将等于0的数组去重
     * <p>
     * 排序+双指针
     * 1.先对数组进行排序
     * 2.固定一个位置,双指针判断
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            //重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                ///判断三个数之和
                int ans = nums[i] + nums[start] + nums[end];
                if (ans > 0) {
                    end--;
                } else if (ans < 0) {
                    start++;
                } else {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[start]);
                    subList.add(nums[end]);
                    res.add(subList);
                    while (start < end && nums[start] == nums[start + 1]) {
                        start = start + 1;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end = end - 1;
                    }
                    start = start + 1;
                    end = end - 1;
                }
            }
        }

        return res;
    }


}




