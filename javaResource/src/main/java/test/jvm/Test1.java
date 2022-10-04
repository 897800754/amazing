package test.jvm;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Random;

/**
 * 测试oom
 *
 * @author: cg1
 * @date: 2021-07-23 17:38
 **/
public class Test1 {
    public static void main(String[] args) {
        int[] ints = new int[1024 * 1024 * 64];

        long nanoTime = System.nanoTime();
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= 3;
        }
        System.out.println("-----" + (System.nanoTime() - nanoTime));

        long nanoTime1 = System.nanoTime();
        for (int i = 0; i < ints.length; i += 1000) {
            ints[i] *= 3;
        }
        System.out.println("-----" + (System.nanoTime() - nanoTime1));

    }
}
