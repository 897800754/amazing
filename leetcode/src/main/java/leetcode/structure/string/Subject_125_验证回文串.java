package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/valid-palindrome/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_125_验证回文串 {
    public static void main(String[] args) {

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome("race a car"));
//        System.out.println(isPalindrome("0P"));
//        System.out.println(isPalindrome("11"));
        System.out.println(isPalindrome("ab_a"));
    }

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int lw = 0;
        int hi = s.length() - 1;
        while (lw < hi) {
            //
            char c = s.charAt(lw);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                //符合要求的字符,比较
                while (lw < hi) {
                    char c1 = s.charAt(hi);
                    if ((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z') || (c1 >= '0' && c1 <= '9')) {
                        if (c == c1 || Character.toLowerCase(c) == Character.toLowerCase(c1)) {
                            hi--;
                            lw++;
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        hi--;
                    }

                }
            } else {
                lw++;
            }
        }
        return true;
    }
}
