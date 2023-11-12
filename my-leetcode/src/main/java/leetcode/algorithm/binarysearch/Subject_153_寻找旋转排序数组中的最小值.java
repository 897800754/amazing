package leetcode.algorithm.binarysearch;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * @author: cg
 * @date: 2023-02-05 23:14
 **/
public class Subject_153_寻找旋转排序数组中的最小值 {


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 1}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));

    }

    public static int findMin(int[] nums) {
        //边界
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int hi = nums.length - 1;

        while (low < hi) {
            int mid = low + (hi - low) / 2;

            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }


}
