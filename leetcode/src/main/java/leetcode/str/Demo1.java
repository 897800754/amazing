package leetcode.str;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(strStr("a11", "1111"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i < haystackArr.length - needleArr.length + 1; i++) {
            //needle循环
            for (int j = 0; j < needleArr.length; j++) {
                if (needleArr[j] != haystackArr[j + i]) {
                    break;
                }
                if (j == needleArr.length - 1) {
                    return i;
                }
            }
        }
        return -1;

    }
}
