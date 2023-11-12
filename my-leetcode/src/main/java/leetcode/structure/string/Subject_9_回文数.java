package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/palindrome-number/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_9_回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(2233));
        System.out.println(isPalindrome(23132));
        System.out.println(isPalindrome(0));
    }


    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
