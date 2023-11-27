package leetcode.structure.arr;

/**
 * https://leetcode.cn/problems/remove-element/¬
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_27_移除元素 {

    public static void main(String[] args) {

        System.out.println(removeElement0(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement0(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));

    }

    /**
     * 快慢指针
     * <p>
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[low] = nums[fast];
                low++;
            }
            fast++;
        }
        return low;
    }

    /**
     * 对向指针
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement0(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}




