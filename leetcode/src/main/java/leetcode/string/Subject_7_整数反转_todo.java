package leetcode.string;

/**
 * https://leetcode.cn/problems/reverse-integer/description/
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_7_整数反转_todo {
    public static void main(String[] args) {

//        char[] chars = {'h', 'e', 'l', 'l', 'o'};
//
//        System.out.println(Arrays.toString(chars));
//        reverse(chars);
//        System.out.println(Arrays.toString(chars));
        int x = 122881;
        System.out.println(x);

        System.out.println(reverse(x));
    }

    public static int reverse0(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        char[] res = new char[chars.length];
        if (chars[0] == '-') {
            //为负数

        } else {

        }
        //反向遍历
        for (int i = chars.length - 1; i >= 0; i--) {


        }
        return Integer.parseInt(new String(res));

    }

    /**
     * my
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        //反转char,注意负数问题
        int p1 = chars[0] == '-' ? 1 : 0;
        int p2 = chars.length - 1;
        while (p2 >= p1) {
            if (chars[p1] != chars[p2]) {
                //不相等
                char temp = chars[p1];
                chars[p1] = chars[p2];
                chars[p2] = temp;
            }
            p2--;
            p1++;
        }

        //验证是否超出32位
        return Integer.parseInt(new String(chars));

    }
}
