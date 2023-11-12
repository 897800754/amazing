package leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * @author: cg
 * @date: 2023-04-21 17:47
 **/
public class Subject_17_电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }

        };
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    /**
     * 枚举所有场景
     * * @param combinations
     *
     * @param phoneMap
     * @param digits
     * @param index
     * @param sb
     */
    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
        } else {
            char c = digits.charAt(index);
            String s = phoneMap.get(c);
            int length = s.length();
            for (int j = 0; j < length; j++) {
                char c1 = s.charAt(j);
                sb.append(c1);
                backtrack(combinations, phoneMap, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}




