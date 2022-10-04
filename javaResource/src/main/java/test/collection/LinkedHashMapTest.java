package test.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: cg1
 * @date: 2021-07-26 11:58
 **/
public class LinkedHashMapTest {
    public static void main(String[] args) {
        lruTest();
    }

    private static void lruTest() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key" + entry.getKey() + "value" + entry.getValue());
        }
        System.out.println("-------------------------------------------");
        map.put("1", "1");
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key" + entry.getKey() + "value" + entry.getValue());
        }

    }
}
