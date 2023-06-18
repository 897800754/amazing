package leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/sort-colors/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_75_颜色分类 {

    public static void main(String[] args) {
        int[] ints = {2, 0, 2, 1, 1, 0};
        sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 两次遍历
     * 第一次遍历吧0放到数组前部
     * 第二次遍历吧2放到数据后部
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {

        //把为0的归到左边,在把为2的归到右边
        int low = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] == 0) {
                //交换
                int temp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = temp;
                low++;
            }
            fast++;
        }
        int zeroEnd = low;
        //反向遍历.@interface
        fast = nums.length - 1;
        low = nums.length - 1;
        while (zeroEnd <= fast) {
            if (nums[fast] == 2) {
                int temp = nums[fast];
                nums[fast] = nums[low];
                nums[low] = temp;
                low--;
            }
            fast--;

        }

    }


}




