package leetcode.structure.arr;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/plus-one/description/
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_66_加一 {

    public static void main(String[] args) {
        int[] req1 = new int[]{9, 9, 9, 9};
        System.out.println(Arrays.toString(req1));
        System.out.println(Arrays.toString(plusOne(req1)));
    }

    public static int[] plusOne(int[] digits) {

        //反向遍历数组
        int digit = digits[digits.length - 1];
        if (digit != 9) {
            digits[digits.length - 1] = digit + 1;
            return digits;
        }
        //==10,需要进位
        digits[digits.length - 1] = 10;
        for (int i = digits.length - 2; i >= 0; i--) {

            if (digits[i + 1] != 10) {
                break;
                //跳出循环
            } else {
                //设置为0,继续循环
                digits[i + 1] = 0;
                //i+1
                digits[i] = digits[i] + 1;
            }
        }
        if (digits[0] == 10) {
            int[] ints = new int[digits.length + 1];
            System.arraycopy(digits, 0, ints, 1, digits.length);
            ints[0] = 1;
            ints[1] = 0;
            return ints;
        }
        return digits;
    }
}




