package leetcode.structure.arr;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_209_长度最小的子数组_TODO {

    public static void main(String[] args) {

        System.out.println(minSubArrayLen0(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
//        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
//        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));

    }

    /**
     * 通过滑动窗口(队列)实现
     * todo
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen0(int target, int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int queueSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ) {
            if (queueSum < target) {
                //进队
                queue.offer(nums[i]);
                queueSum += nums[i];
                i++;
            } else {
                //出队
                min = Math.min(min, queue.size());
                Integer poll = queue.poll();
                if (poll != null) {
                    queueSum -= poll;
                }
            }
        }
        return target == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 超出时间限制
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    //是否为最小的数组
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min <= nums.length ? min : 0;
    }
}




