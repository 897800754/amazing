package leetcode.structure.arr;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 *
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/
 *
 * @author: cg
 * @date: 2023-04-21 17:19
 **/
public class Subject_26_删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] req = new int[]{1, 1, 2, 3, 3, 5};
        int i = removeDuplicates(req);
        System.out.println(i);
        System.out.println(Arrays.toString(req));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        //使用快慢指针
        int fast = 1;
        int low = 0;

        for (; fast < nums.length; fast++) {
            //快指针
            if (nums[fast] != nums[low]) {
                nums[++low] = nums[fast];
            }
        }
        return low + 1;
    }
}
