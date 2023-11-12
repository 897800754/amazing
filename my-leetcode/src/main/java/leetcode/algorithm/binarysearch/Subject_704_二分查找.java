package leetcode.algorithm.binarysearch;

/**
 * https://leetcode.cn/problems/remove-element/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_704_二分查找 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, -2));
        System.out.println(search(new int[]{0, 3, 5}, 3));
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        if (nums[0] > target) {
            return -1;
        }
        if (nums[nums.length - 1] < target) {
            return -1;
        }

        while (l <= h) {
            int index = (l + h) / 2;
            if (nums[index] > target) {
                h = index - 1;
            } else if (nums[index] < target) {
                l = index + 1;
            } else {
                return index;
            }
        }
        return -1;
    }
}




