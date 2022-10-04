package leetcode.num;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(IsPalindrome2(211112));
    }

    public static boolean isPalindrome(int x) {
        char[] array = new Integer(x).toString().toCharArray();
        int begin = 0;
        int end = array.length - 1;
        boolean flag = true;
        while (flag) {
            if (begin >= end) {
                return true;
            }
            if (array[begin++] != array[end--]) {
                return false;
            }
        }
        return false;
    }

    public static boolean IsPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int num = 0;
        while (x > num) {
            //x = 1221
            //x = 12121
            num = num * 10 + x % 10;
            x /= 10;
        }
        return x == num || x == num / 10;

    }

}
