package leetcode.algorithm.binarysearch;

/**
 * https://leetcode.cn/problems/search-insert-position/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_35_搜索插入位置 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{-1, 0, 3, 5, 9, 12}, 4));
    }

    /**
     * @param nums
     * @param target [2,4,6] 3
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
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
        return nums[l] > target ? l : l - 1;
    }

}




