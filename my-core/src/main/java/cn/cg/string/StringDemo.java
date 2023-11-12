package cn.cg.string;

/**
 * @author: cg
 * @date: 2023-03-20 22:31
 **/
public class StringDemo {
    public static void main(String[] args) {
        //"aaa" 字面量,
        String s = "aaa";
        //s1指向堆内存中字符串对象
        String s1 = new String("aaa");
        System.out.println(s1 == s);           // false

        String s2 = new String("aaa");
        System.out.println(s1 == s2);          // false
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4);           // true
        String s5 = "bbb";
        String s6 = "bbb";
        System.out.println(s5 == s6);  // true
    }
}
