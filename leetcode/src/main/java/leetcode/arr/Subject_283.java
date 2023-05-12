package leetcode.arr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/description/
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_283 {

    public static void main(String[] args) {
//        int[] req1 = new int[]{0, 1, 0, 3, 12};
        int[] req1 = new int[]{0};
        System.out.println(Arrays.toString(req1));
        moveZeroes1(req1);
        System.out.println(Arrays.toString(req1));
//        System.out.println(Arrays.toString(intersect1(req1, req2)));
    }

    /**
     * 一次遍历
     * 最优解
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int index1 = 0;
        int index2 = 1;
        while (index2 <= (nums.length - 1)) {
            if (nums[index1] == 0) {
                while (index2 <= nums.length - 1) {
                    if (nums[index2] == 0) {
                        index2++;
                    } else {
                        int temp = nums[index1];
                        nums[index1] = nums[index2];
                        nums[index2] = temp;
                        index2++;
                        index1++;
                        break;
                    }
                }
            } else {
                index1++;
                index2++;
            }
        }
    }

    /**
     * 高低指针,错误,不支持非0元素的有序
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            if (nums[startIndex] == 0) {
                //交换位置
                int temp = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = temp;
                endIndex--;
                startIndex++;
            } else {
                startIndex++;
            }
        }
    }
}




