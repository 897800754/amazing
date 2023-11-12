package cn.cg;

/**
 * @author: cg
 * @date: 2023-03-20 22:00
 **/
public class IntegerDemo {

    public static void main(String[] args) {
        //
        Integer i = 1;
        Integer i1 = 1;
        Integer i2 = Integer.valueOf(1);
        System.out.println(i == i1);
        System.out.println(i == i2);
        Integer a = new Integer(1);
        Integer a1 = new Integer(1);
        System.out.println(a == a1);
    }
}
