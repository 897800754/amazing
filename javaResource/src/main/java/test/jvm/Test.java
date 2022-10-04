package test.jvm;

import java.util.HashMap;
import java.util.Random;

/**
 * 测试oom
 *
 * @author: cg1
 * @date: 2021-07-23 17:38
 **/
public class Test {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < 1000000000; i++) {
            map.put(i, new Random().nextInt());
        }
    }
}
