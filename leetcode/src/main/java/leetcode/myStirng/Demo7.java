package leetcode.myStirng;

import java.util.Scanner;

/**
 * 输入一个字符串,判断他是否是数字类型(),果然是返回true,不是返回false
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String num = sc.next();
            System.out.println("该字符串为数字吗?  " + fun(num));
            //测试使用,仅供参考
            try {
                Long.parseLong(num);
            } catch (RuntimeException e) {
                try {
                    System.out.println(Double.parseDouble(num));
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    System.out.println("false");
                }
            }
        }
    }

    private static boolean fun(String num) {
        //返回值
        boolean flag = true;
        //数组索引
        int i = 0;
        char[] chars = num.toCharArray();
        //小数标记
        boolean pointFlag = true;
        if (chars[0] == '-') {
            //负数判断
            i++;
        }
        for (; i < chars.length; i++) {
            if (chars[i] < 48 || chars[i] > 57) {
                //非数字
                if (pointFlag && chars[i] == '.' && i != 0 && i != chars.length - 1) {
                    //小数点有且仅能有一个,并且不为第一位和最后一位
                    pointFlag = false;
                    continue;
                }
                flag = false;
                break;
            }
        }
        return flag;
    }
}
