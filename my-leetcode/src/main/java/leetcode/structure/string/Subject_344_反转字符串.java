package leetcode.structure.string;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_344_反转字符串 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};

        System.out.println(Arrays.toString(chars));
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void reverseString(char[] s) {
        int p1 = 0;
        int p2 = s.length - 1;

        while (p1 <= p2) {
            if (s[p1] != s[p2]) {
                //进行替换
                char temp = s[p1];
                s[p1] = s[p2];
                s[p2] = temp;
            }
            p1++;
            p2--;
        }
    }
}
