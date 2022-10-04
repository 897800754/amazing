package jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: cg1
 * @date: 2021-07-24 23:56
 **/
public class Test {
    public static void main(String[] args) {
        String s = ClassLayout.parseInstance(new Object()).toPrintable();
        synchronized (s) {
            System.out.println(s);
        }


    }
}
