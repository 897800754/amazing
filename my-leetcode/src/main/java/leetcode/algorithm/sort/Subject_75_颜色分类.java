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
//        int[] ints = {1, 2, 0};
        sortColors0(ints);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 对撞指针
     * P1:左指针
     * P2:右指针
     *
     * @param nums
     */
    public static void sortColors0(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;

        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
                i--;

            } else {

            }
        }
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




