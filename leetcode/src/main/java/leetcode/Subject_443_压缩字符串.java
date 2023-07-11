package leetcode;

/**
 * https://leetcode.cn/problems/string-compression/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_443_压缩字符串 {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
//        System.out.println(compress(new char[]{'a'}));
    }


    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        int low = 0;
        int sum = 0;
        int fast = 1;
        while (fast < chars.length) {
            char aChar = chars[fast];
            char lowChar = chars[low];
            if (lowChar == aChar) {
                if (fast != chars.length-1) {
                    continue;
                }
                fast++;
                sum++;
            }
            //不相等了
            //sum=1时,low进位
            if (sum == 1) {
                low++;
                fast++;
            } else {
                String s = String.valueOf(sum);
                for (int i = 0; i < s.toCharArray().length; i++) {
                    low++;
                    chars[low] = s.charAt(i);
                }
                low++;
                if (fast!= chars.length) {
                    chars[low] = chars[fast];
                }

            }
            sum = 0;


        }
        return low - 1;
    }


}




