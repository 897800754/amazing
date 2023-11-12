package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/valid-anagram/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_242_有效的字母异位词 {
    public static void main(String[] args) {
        System.out.println(isAnagram("ba", "ab"));
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("abb", "bbc"));
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            ints[t.charAt(i) - 'a']--;
        }
        for (int anInt : ints) {
            if (anInt != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 错误,不能使用该方法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        int ct = 0;
        int ct1 = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            ct += c;
            ct1 += c1;
            temp = temp ^ c ^ c1;
        }
        return temp == 0 && ct == ct1;
    }
}
