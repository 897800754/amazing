package cn.cg.concurrent.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: cg
 * @date: 2023-03-24 18:51
 **/
public class StampedDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        AtomicStampedReference<Map<String, Object>> atomicStampedReference = new AtomicStampedReference<>(map, 0);
        int stamp = atomicStampedReference.getStamp();
    }
}
