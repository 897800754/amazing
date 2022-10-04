package leetcode.str;

/**
 * 实现函数 ToLowerCase()，
 * 该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * 输入: "Hello"
 * 输出: "hello"
 */
public class Demo3 {
    public static void main(String[] args) {
        System.out.println(toLowerCase("ADScxzADASaaaac"));
    }

    public static String toLowerCase(String str) {
        if (str == null) return "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return String.valueOf(chars);
    }
}
