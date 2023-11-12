package leetcode.structure.string;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solutions/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_剑指Offer58II_左旋转字符串 {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords0("abcdefg", 2));
    }

    /**
     * 开辟新的数组空间发
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords0(String s, int n) {
        //找到真实需要移动的位数
        int k = n % s.length();
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                chars[s.length() - k + i] = s.charAt(i);
            } else {
                chars[i - k] = s.charAt(i);
            }
        }

        return new String(chars);

    }

    public static String reverseLeftWords(String s, int n) {
        //找到真实需要移动的位数
        int k = n % s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                sb.append(s.charAt(i));
            } else {
                sb1.append(s.charAt(i));
            }
        }
        sb1.append(sb);
        return sb1.toString();
    }


}




