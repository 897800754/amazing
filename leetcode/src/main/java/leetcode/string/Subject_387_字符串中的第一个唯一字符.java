package leetcode.string;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/first-unique-character-in-a-string/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_387_字符串中的第一个唯一字符 {
    public static void main(String[] args) {


        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        //hash表 计数
        for (int i = 0; i < chars.length; i++) {
            map.compute(chars[i], (key, value) -> {
                if (value == null) {
                    value = 1;
                } else {
                    value++;
                }
                return value;
            });
        }
        //遍历数组
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer == 1) {
                return i;
            }
        }
        return -1;
    }
}
