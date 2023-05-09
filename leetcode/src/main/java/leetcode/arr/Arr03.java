package leetcode.arr;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Arr03 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        int k = 0;
        rotate1(arr, k);
    }

    /**
     * 额外数组
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        //先对k进行取模,k为下标
        //le = 7, k=3,k1 = 7-4 =3
        int k1 = nums.length - (nums.length % k);

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i > k1) {
//                arr[] =nums[i];
            } else {

            }
        }


    }


}
