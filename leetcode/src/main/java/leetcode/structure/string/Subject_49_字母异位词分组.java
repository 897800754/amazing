package leetcode.structure.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * @author: cg
 * @date: 2023-05-10 11:12
 **/
public class Subject_49_字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"abbbbbbbbbbb", "aaaaaaaaaaab"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> lists = new ArrayList<>();

        HashMap<String, int[]> cache = new HashMap<>();

        for (String str : strs) {
            boolean flag = false;
            cache.computeIfAbsent(str, key -> {
                        int[] ints = new int[26];
                        char[] chars = key.toCharArray();
                        for (char aChar : chars) {
                            ints[aChar - 'a']++;
                        }
                        return ints;
                    }
            );

            a:
            for (List<String> list : lists) {
                if (!list.isEmpty()) {
                    String s = list.get(0);

                    cache.computeIfAbsent(s, key -> {
                        int[] ints = new int[26];
                        char[] chars = key.toCharArray();
                        for (char aChar : chars) {
                            ints[aChar - 'a']++;
                        }
                        return ints;
                    });

                    int[] sInt = cache.get(s);
                    int[] ints = cache.get(str);
                    //比较两个数组是否相等
                    for (int i = 0; i < ints.length; i++) {
                        if (ints[i] != sInt[i]) {
                            continue a;
                        }
                    }
                    flag = true;
                    list.add(str);
                    break;
                }
            }
            //没有加入到内层list
            if (!flag) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                lists.add(strings);
            }
        }
        return lists;
    }
}
