package leetcode;

/**
 * https://leetcode.cn/problems/string-compression/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_443_压缩字符串_TODO {

    public static void main(String[] args) {
//        System.out.println(compress(new char[]{'b', 'c', 'c'}));
        System.out.println(compress(new char[]{'b', 'c', 'c', 'd'}));
//        System.out.println(compress(new char[]{'a'}));
    }


    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        //b,c,c
        int low = 0;
        int sum = 0;
        int fast = 0;
        while (fast < chars.length) {
            char lowChar = chars[low];
            char fastChar = chars[fast];
            if (lowChar == fastChar) {
                sum++;
                if (fast != chars.length - 1) {
                    fast++;
                    continue;
                }
//                fast++;
            }

            if (fast == chars.length - 1) {
                chars[low] = chars[fast];
            } else {
                chars[low] = chars[fast - 1];
            }
            if (sum == 1 && low != chars.length - 1) {
                low++;
            } else {
                //todo
                String sumStr = String.valueOf(sum);
                for (int i = 0; i < sumStr.toCharArray().length; i++) {
                    char c = sumStr.charAt(i);
                    low++;
                    chars[low] = c;
                }
                if (low != chars.length - 1) {
                    low++;
                } else {
                    break;
                }
            }
            sum = 0;
        }
        return low + 1;
    }


}




