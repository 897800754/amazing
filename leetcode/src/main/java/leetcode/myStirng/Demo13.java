package leetcode.myStirng;

/**
 * 情况一
 * 例如 String x1 = new.....+"xxx"
 * String x2 = new.....
 * String x3= new +new
 * 只要出现new,则再堆内存---->x1!=x2!=x3
 * 情况二
 * String x1 = "xxx"+"xxx"
 * String x2 = "xxxxxx"
 * String x3= "x"+"x"+"xxxx"
 * 没有出现new 则 x1=x2=x3
 */
public class Demo13 {
    public static void main(String[] args) {
        String s = "111";
        String s1 = new String("111");
        String s2 = "1" + "1" + "1";
        String s3 = "11" + new String("1");
        String s4 = new String("11") + new String("1");
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s1 == s2);
        System.out.println(s == s3);
        System.out.println(s1 == s3);
        System.out.println(s == s4);
        System.out.println(s3 == s4);
        System.out.println(s1 == s4);
    }
}
