package leetcode.myStirng;

/**
 * @author Administrator
 * @title: Demo5
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/6/2810:51
 */
public class Demo5 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        double n = 100000L;
        //字符串
        String str = "";
        for (int i = 0; i < n; i++) {
            str += i;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') count++;
        }
        System.out.println(count);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
