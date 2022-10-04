package test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: cg1
 * @date: 2020-09-03 22:01
 **/
public class MyMap {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1, 1);
        objectObjectHashMap.get(1);
        test();
    }


    private static void test() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");
        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key + " \tIdx(16)：" + ((16 - 1) & hash) + " \tBit值：" + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16) + " \t\tIdx(32)：" + Integer.toBinaryString(key.hashCode()) + " " + Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }

    }
}
